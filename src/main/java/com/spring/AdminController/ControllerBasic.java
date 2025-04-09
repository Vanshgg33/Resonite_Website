package com.spring.AdminController;

import jakarta.persistence.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerBasic {
    @GetMapping("/Resonite1Admin")
    public String page() {
        return "AdminPage";
    }

    @GetMapping("/usersinfo")
    public String in() {
        return "alluser";
    }


}
