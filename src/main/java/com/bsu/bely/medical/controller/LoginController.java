package com.bsu.bely.medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model, @RequestParam(value = "error", required = false) String loginError) {
        if (loginError != null) {
            model.addAttribute("loginError", true);
        }
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(ModelMap model) {
        model.addAttribute("message", "From Login");
        return "admin";
    }
}
