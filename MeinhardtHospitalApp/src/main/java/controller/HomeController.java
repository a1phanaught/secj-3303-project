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

import entity.Patient;
import service.PatientDao_usingHibernate;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/index")
	@ResponseBody()
	public String homepage() {
		return "Welcome to Meinhardt Homepage";
	}
	
}
