package com.nikhilrana.springmvcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String hello() {
        return "home";
    }

    @GetMapping("/leaders")
    public String getLeadersPage() {

        return "leaders-page";
    }

    @GetMapping("/systemAdmins")
    public String getSystemAdminPage() {

        return "systemAdmins-page";
    }

    @GetMapping("/access-denied")
    public String getAccessDeniedPage() {

        return "access-denied";
    }

}
