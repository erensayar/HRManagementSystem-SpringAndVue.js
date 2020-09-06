package com.erensayar.HrApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

/**
 * @author erensayar
 */
@Controller
public class ViewController {

    @GetMapping(value = "/")
    public String redirectHome() {
        return "redirect:/home";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/detailsOfJob/{id}")
    public String detailsOfJob(@PathVariable Integer id, Model model) {
        model.addAttribute("jobId", id);
        return "detailsOfJob";
    }

    @GetMapping(value = "/apply/{id}")
    public String apply(@PathVariable Integer id, Model model) {
        model.addAttribute("jobId", id);
        return "apply";
    }

    @GetMapping(value = "/applyDone")
    public String applyDone() {
        return "applyDone";
    }

    // Admin
    //<=====================================================================>    
    @GetMapping(value = "/adminHome")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping(value = "/detailsOfApplicant/{id}")
    public String detailsOfApplicant(@PathVariable Integer id, Model model) {
        model.addAttribute("applicantId", id);
        return "detailsOfApplicant";
    }

    @GetMapping(value = "/addJob")
    public String addJob() {
        return "addJob";
    }

}
