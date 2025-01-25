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
import service.DoctorDao;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorDao cDao;
	
	@RequestMapping("/getall")
	@ResponseBody()
	public String getall() {
		List<Doctor> clist = cDao.findAll();
		return "this is getall" + clist.toString();
	}
	
	@RequestMapping("/get1")
	@ResponseBody()
	public String getDoctor() {
		Doctor clist = cDao.getDoctorById(1);
		return "this is getall" + clist.toString();
	}
	
	@GetMapping("/register")
    public ModelAndView showRegistrationForm(Model model) {
		return new ModelAndView("doctor-registration");
    }

    @PostMapping("/register")
    public String registerDoctor(@ModelAttribute("doctor") Doctor doctor) {
        cDao.saveDoctor(doctor);
        return "redirect:/doctor/getall";
    }
    
    @GetMapping("/login")
    public ModelAndView showLoginForm(Model model) {
		return new ModelAndView("doctor-login");
    }
    
    /*@PostMapping("/login")
    public String loginDoctor(@RequestParam("email") String email, @RequestParam("password") String password, Model model,  HttpSession session) {
        // Implement your login logic here
        Doctor doctor = cDao.getDoctorByEmail(email, password);
        if (doctor != null) {
        	session.setAttribute("doctor", doctor);
            //model.addAttribute("doctor", doctor);
            return "redirect:/doctor/getall"; // Redirect to a dashboard or another page
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "doctor-login"; // Redirect back to the login page
        }
    }*/
    @PostMapping("/login")
    public String loginDoctor(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, HttpServletRequest request) {
        Doctor doctor = cDao.getDoctorByEmail(email, password);
        if (doctor != null) {
            session.invalidate(); // Invalidate the current session
            session = request.getSession(true); // Create a new session
            session.setAttribute("doctor", doctor); // Set the new attribute
            model.addAttribute("doctor", doctor);
            return "redirect:/doctor/getall"; // Redirect to a dashboard or another page
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "doctor-login"; // Redirect back to the login page
        }
    }
}
