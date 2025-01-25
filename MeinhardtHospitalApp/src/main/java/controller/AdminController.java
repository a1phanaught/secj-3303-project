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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Admin;
import service.AdminDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminDao aDao;
    
    @RequestMapping("/getall")
    @ResponseBody()
    public String getAll() {
        List<Admin> alist = aDao.findAll();
        return "this is getall" + alist.toString();
    }
    
    @RequestMapping("/get1")
    @ResponseBody()
    public String getAdmin() {
        Admin admin = aDao.getAdminById(1);
        return "this is getall" + admin.toString();
    }
    
    @GetMapping("/register")
    public ModelAndView showRegistrationForm(Model model) {
        return new ModelAndView("admin-registration");
    }

    @PostMapping("/register")
    public String registerAdmin(@ModelAttribute("admin") Admin admin) {
        aDao.saveAdmin(admin);
        return "redirect:/admin/getall";
    }
    
    @GetMapping("/login")
    public ModelAndView showLoginForm(Model model) {
        return new ModelAndView("admin-login");
    }
    
    @PostMapping("/login")
    public String loginAdmin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        // Implement your login logic here
        Admin admin = aDao.getAdminByUsername(username, password);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "redirect:/admin/getall"; // Redirect to a dashboard or another page
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "admin-login"; // Redirect back to the login page
        }
    }
}