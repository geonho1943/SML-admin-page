package com.manage.sml.smlAdminPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String getDashboard() {
        return "main";
    }
    
}