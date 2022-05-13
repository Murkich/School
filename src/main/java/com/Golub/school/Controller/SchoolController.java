package com.Golub.school.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SchoolController {
    @GetMapping("/")
    public String redirectSchool() {
        return "redirect:/request";
    }
}
