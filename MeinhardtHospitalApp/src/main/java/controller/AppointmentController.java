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

import entity.Appointment;
import service.AppointmentDao;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentDao cDao;
	
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
}