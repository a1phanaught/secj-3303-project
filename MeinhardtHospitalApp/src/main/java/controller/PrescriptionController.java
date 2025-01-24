package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import entity.Prescription;
import service.PrescriptionDao;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {
	@Autowired // spring dependency injection
	private PrescriptionDao cDao;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            public void setAsText(String text) {
                setValue(LocalDate.parse(text, dateFormatter));
            }
        });
	}
        
	@RequestMapping("/getall")
	@ResponseBody()
	public String getall() {
		List<Prescription> clist = cDao.findAll();
		return "this is getall" + clist.toString();
	}
	
	@GetMapping("/register")
	public ModelAndView registration() {
		return new ModelAndView("prescription-registration");
	}
	
	
	@PostMapping("/register")
	public String registerPrescription(@ModelAttribute("prescription") Prescription prescription) {
	    System.out.println("Register Prescription sucessfull: " + prescription);
	    cDao.savePrescription(prescription);
	    return "redirect:/prescription/getall";
	}

	
	@GetMapping("/update")
	public String updatePrescription(@PathVariable int id, @ModelAttribute("prescription") Prescription newPrescription) {
	    Prescription updatedPrescription = cDao.updatePrescription(id, newPrescription);
	    if (updatedPrescription != null) {
	        return "redirect:/prescription/getall";
	    }
		return null; 
	}

	@RequestMapping ("/get1")
	@ResponseBody()
	public String getPrescription() {
		Prescription clist = cDao.getPrescriptionById(1);
		return "this is getall" + clist.toString();
	}

}
