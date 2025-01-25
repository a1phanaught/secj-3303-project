package controller;

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

import entity.Doctor;
import entity.Patient;
import service.PatientDao_usingHibernate;

@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired // spring dependency injection
	private PatientDao_usingHibernate cDao_usingHibernate;
	
	@RequestMapping("/getall")
	@ResponseBody()
	public String getall() {
		List<Patient> clist = cDao_usingHibernate.findAll();
		return "this is getall" + clist.toString();
	}
	
	@GetMapping("/register")
	public ModelAndView registration() {
		return new ModelAndView("patient-registration");
	}
	
	@PostMapping("/register")
    public String registerPatient(@ModelAttribute("patient") Patient patient) {
        cDao_usingHibernate.savePatient(patient);
        return "redirect:/patient/getall";
    }
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("patient-login");
	}
	
	/*@PostMapping("/login")
    public String loginPatient(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        // Implement your login logic here
        Patient patient = cDao_usingHibernate.getPatientByEmail(email, password);
        if (patient != null) {
            model.addAttribute("patient", patient);
            return "redirect:/patient/getall"; // Redirect to a dashboard or another page
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "patient-login"; // Redirect back to the login page
        }
    }*/
	
	@PostMapping("/login")
	public String loginPatient(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, HttpServletRequest request) {
	    // Implement your login logic here
	    Patient patient = cDao_usingHibernate.getPatientByEmail(email, password);
	    if (patient != null) {
	        session.invalidate(); // Invalidate the current session
	        session = request.getSession(true); // Create a new session
	        session.setAttribute("patient", patient); // Set the new attribute
	        return "redirect:/patient/getall"; // Redirect to a dashboard or another page
	    } else {
	        model.addAttribute("error", "Invalid email or password");
	        return "patient-login"; // Redirect back to the login page
	    }
	}
}