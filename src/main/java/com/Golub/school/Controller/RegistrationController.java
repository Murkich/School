package com.Golub.school.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reg")
public class RegistrationController {

    @GetMapping
    public String showRegPage(Model model){
        return "reg";
    }
}
