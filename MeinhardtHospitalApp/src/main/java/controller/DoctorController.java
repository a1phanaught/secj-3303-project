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
}
