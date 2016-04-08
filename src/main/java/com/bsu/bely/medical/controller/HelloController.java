package com.bsu.bely.medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/welcome")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "index";
    }
}
