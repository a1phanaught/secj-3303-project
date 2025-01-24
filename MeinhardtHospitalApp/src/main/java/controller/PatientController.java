package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
}