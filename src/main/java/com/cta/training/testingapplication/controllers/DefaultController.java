package com.cta.training.testingapplication.controllers;

import com.cta.training.testingapplication.application.Application;
import com.cta.training.testingapplication.repositories.ApplicationRepository;
import com.cta.training.testingapplication.application.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class DefaultController {

    @Autowired
    private ApplicationRepository repository;

    @GetMapping("/")
    public String home1() {
        return "home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }


    @GetMapping("/application")
    public String showForm(Model model){
        model.addAttribute("application", new Application());
        return "application";
    }

    @PostMapping("/application")
    public String checkPersonInfo(@Valid @ModelAttribute Application application, BindingResult bindingResult) {
        return new ResponseHandler().returnResponse(bindingResult,repository, application);
    }

    @GetMapping("/applications")
    public String getAllApps(Model model){
        model.addAttribute("applications", repository.findAll());
        return "applications";
    }

    @GetMapping("/application/{number}")
    public @ResponseBody Optional<Application> getApplication(@PathVariable("number") Long number){
        return new ResponseHandler().returnApplication(repository,number);
    }

    @GetMapping("/application/{number}/delete")
    public String deleteApplication(@PathVariable("number") Long number){
        new ResponseHandler().deleteApplication(repository,number);
        return "redirect:/applications";
    }

    @GetMapping("/search")
    public String searchApplication(){
        return "search";
    }

    @PostMapping("/search")
    public String postSearch() {
        return null;
    }

    @GetMapping("/search-results")
    public @ResponseBody Optional<Application> searchResults(@PathVariable("string") String searchString){
        return new ResponseHandler().search(repository,searchString);
    }

}
