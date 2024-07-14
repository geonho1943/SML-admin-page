package com.manage.sml.smlAdminPage.controller;

import com.manage.sml.smlAdminPage.service.gendummydata.DummyDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {

    @Autowired
    DummyDataGenerator dummyDataGenerator;

    @GetMapping("/")
    public String getDashboard() {
        return "main";
    }

    @GetMapping("/dummy")
    public String getdummy() throws Exception {
        dummyDataGenerator.generateDummyData();
        return "ok";
    }

}