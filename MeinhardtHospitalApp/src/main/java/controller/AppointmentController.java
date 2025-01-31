package controller;

import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import service.AppointmentDao;
import service.DoctorDao;
import service.PatientDao_usingHibernate;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentDao cDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private PatientDao_usingHibernate patientDao;
	
	@RequestMapping("/getall")
	@ResponseBody()
	public String getall() {
		List<Appointment> clist = cDao.findAll();
		return "this is getall" + clist.toString();
	}
	
	@RequestMapping("/get1")
	@ResponseBody()
	public String getAppointment() {
		Appointment clist = cDao.getAppointmentById(1);
		return "this is getall" + clist.toString();
	}
	
	@GetMapping("/create")
    public ModelAndView showRegistrationForm(Model model) {
		return new ModelAndView("appointment-create");
    }
	
	@PostMapping("/create")
	public String createAppointment(@RequestParam("doctor_id") int doctorId,
	                                @RequestParam("patient_id") int patientId,
	                                @RequestParam("datetime") String datetime,
	                                @RequestParam("description") String description,
	                                HttpSession session, Model model) {
	    // Validate inputs
	    if (doctorId <= 0 || patientId <= 0 || datetime == null || datetime.isEmpty()) {
	        model.addAttribute("error", "Invalid input. Please check all fields and try again.");
	        return "appointment-create";
	    }

	    // Set doctor and patient entities
	    Doctor doctor = doctorDao.getDoctorById(doctorId);
	    Patient patient = patientDao.getPatientById(patientId);
	    if (doctor == null || patient == null) {
	        model.addAttribute("error", "Doctor or Patient not found.");
	        return "appointment-create";
	    }

	    // Parse datetime
	    LocalDateTime appointmentDateTime;
	    try {
	        appointmentDateTime = LocalDateTime.parse(datetime);
	    } catch (Exception e) {
	        model.addAttribute("error", "Invalid date format.");
	        return "appointment-create";
	    }

	    // Create and save appointment
	    Appointment appointment = new Appointment();
	    appointment.setDoctor(doctor);
	    appointment.setPatient(patient);
	    appointment.setDatetime(appointmentDateTime);
	    appointment.setDescription(description);

	    try {
	        cDao.saveAppointment(appointment);
	        return "redirect:/doctor/dashboard";
	    } catch (Exception e) {
	        model.addAttribute("error", "An error occurred while creating the appointment. Please try again.");
	        return "appointment-create";
	    }
	}
	
	@PostMapping("/delete")
	public String deleteAppointment(@RequestParam("appointment_id") int appointmentId, Model model) {
	    try {
	        cDao.deleteAppointmentById(appointmentId);
	        return "redirect:/doctor/dashboard";
	    } catch (Exception e) {
	        model.addAttribute("error", "An error occurred while deleting the appointment. Please try again.");
	        return "doctor-dashboard";
	    }
	}
	
	@GetMapping("/edit")
	public String showEditForm(@RequestParam("appointment_id") int appointmentId, Model model) {
	    Appointment appointment = cDao.getAppointmentById(appointmentId);
	    if (appointment == null) {
	        model.addAttribute("error", "Appointment not found.");
	        return "doctor-dashboard";
	    }
	    model.addAttribute("appointment", appointment);
	    return "appointment-edit";
	}

	@PostMapping("/edit")
	public String editAppointment(@RequestParam("appointment_id") int appointmentId,
	                              @RequestParam("datetime") String datetime,
	                              @RequestParam("description") String description,
	                              Model model) {
	    Appointment appointment = cDao.getAppointmentById(appointmentId);
	    if (appointment == null) {
	        model.addAttribute("error", "Appointment not found.");
	        return "appointment-edit";
	    }

	    // Parse datetime
	    LocalDateTime appointmentDateTime;
	    try {
	        appointmentDateTime = LocalDateTime.parse(datetime);
	    } catch (Exception e) {
	        model.addAttribute("error", "Invalid date format.");
	        return "appointment-edit";
	    }

	    // Update appointment details
	    appointment.setDatetime(appointmentDateTime);
	    appointment.setDescription(description);

	    try {
	        cDao.saveAppointment(appointment);
	        return "redirect:/doctor/dashboard";
	    } catch (Exception e) {
	        model.addAttribute("error", "An error occurred while updating the appointment. Please try again.");
	        return "appointment-edit";
	    }
	}
}