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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Patient;
import service.PatientDao_usingHibernate;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping("/homie")
	@ResponseBody()
	public String hometown() {
		return "this is homie";
	}

	//@RequestMapping(value="/home",method=RequestMethod.GET)
	@GetMapping("/home")
	public ModelAndView homepage() {
		ModelAndView modelandview = new ModelAndView("home");
		modelandview.addObject("message", "Meinhardt Hospital homepage");
		return modelandview;
	}
}
