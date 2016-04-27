package com.bsu.bely.medical.controller;

import com.bsu.bely.medical.entity.Patient;
import com.bsu.bely.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
//    @Autowired
//    private PatientService patientService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:/admin";
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
//        if (patientService != null)
//        {
//            Patient patient = new Patient();
//            patient.setFirstName("Anton");
//            patient.setLastName("Bely");
//            patient.setPassport("MP3025105");
//            patient.setTelephoneNumber("+375256560507");
//
//            patientService.addPatient(patient);
//        }
        return "admin";
    }
}
