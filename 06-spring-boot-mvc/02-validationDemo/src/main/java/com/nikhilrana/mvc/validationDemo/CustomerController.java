package com.nikhilrana.mvc.validationDemo;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String getForm(Model model) {

        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult
    ) {

        System.out.println(bindingResult.toString());

        if(bindingResult.hasErrors()) {
            return "customer-form";
        }
        return "customer-success";
    }


    // add an init binder which will call every time whenever any request is invoked
    // Used to remove trailing and leading whitespaces
    // resolve issue for validation
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        // It register the String class such that it preprocess every string form data
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


}
