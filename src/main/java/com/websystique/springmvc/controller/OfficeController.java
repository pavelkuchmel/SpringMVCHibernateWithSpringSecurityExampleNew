package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.OfficeService;
import com.websystique.springmvc.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/offices")
@SessionAttributes("roles")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private MessageSource messageSource;

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @RequestMapping(value = {"/list" }, method = RequestMethod.GET)
    public String listOffices(ModelMap model) {

        List<Office> offices = officeService.findAll();
        model.addAttribute("offices", offices);
        model.addAttribute("loggedinuser", getPrincipal());
        return "officelist";
    }


    @RequestMapping(value = {"/view-office-{id}" }, method = RequestMethod.GET)
    public String viewOffice(@PathVariable Integer id,  ModelMap model) {
        Office office = officeService.findById(id);
        model.addAttribute("office", office);
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("edit", true); // ?

        return "viewoffice";
    }

    @RequestMapping(value = {"/create-office" }, method = RequestMethod.GET)
    public String showCreateOffice(ModelMap model) {
        model.addAttribute("office", new Office());
        model.addAttribute("loggedinuser", getPrincipal());
        model.addAttribute("edit", true);

        return "createoffice";
    }

    @RequestMapping(value = {"/create-office" }, method = RequestMethod.POST)
    public String createOffice(@Valid Office office, ModelMap model) {
        String msg = officeService.createOffice(office);
        model.addAttribute("msg", msg);

        return "redirect:/list";
    }





}
