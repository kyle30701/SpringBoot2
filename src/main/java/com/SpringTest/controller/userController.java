package com.SpringTest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.SpringTest.entity.User;
import com.SpringTest.service.userService;



@Controller
public class userController {
	private final Logger logger = LoggerFactory.getLogger(userController.class);
	
	@Autowired
    private userService service;
	
	@GetMapping({"/","/login"})
    public String show(){
        return "login";
    }
	

	
	@RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String username,String password){
        User userB = service.LoginIn(username, password);
        logger.info("username:{}",username);
        logger.info("password:{}",password);
        if(userB!=null){
            return "redirect:/main";
        }else {
            return "error";
        }
    }
 
    @GetMapping("/main")
    public String viewHomePage(Model model) {
        List<User> listuser = service.listAll();
        model.addAttribute("listuser", listuser);
        return "main";
    }
 
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") User uB) {
        service.save(uB);
        return "redirect:/main";
    }
 
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        User uB = service.get(id);
        mav.addObject("user", uB);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/main";
    }
    
    
}

