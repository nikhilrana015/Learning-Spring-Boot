package com.nikhilrana.thymeLeafDemo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoContoller {

    @GetMapping("/")
    public String helloWorld(Model model) {

        model.addAttribute("date", new java.util.Date());

        // we have thymeleaf dependency, so it looks for template file named helloworld.html
        // file should present at src/main/resources/templates/helloworld.html
        return "helloworld";

    }

}
