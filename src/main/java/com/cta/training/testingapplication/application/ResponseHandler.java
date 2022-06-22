package com.cta.training.testingapplication.application;

import com.cta.training.testingapplication.repositories.ApplicationRepository;
import org.springframework.validation.BindingResult;

import java.util.Optional;

public class ResponseHandler {

    public ResponseHandler() {
    }

    public String returnResponse(BindingResult bindingResult, ApplicationRepository repository, Application application) {

        if (bindingResult.hasErrors()) {
            return "application";
        }

        if (application.getAmount() >= 15000) {
            return "failed";
        }

        repository.save(application);
        return "results";
    }

    public Iterable<Application> returnAll(ApplicationRepository repository) {
        return repository.findAll();
    }

    public Optional<Application> returnApplication(ApplicationRepository repository, Long number) {
        return repository.findById(number);
    }

    public void deleteApplication(ApplicationRepository repository, Long number) {
        repository.deleteById(number);
    }

    public Optional<Application> search(ApplicationRepository repository, String searchTerm) {
        Iterable<Application> apps = repository.findAll();
        for (Application app : apps){
            if (app.getFirstName().equals(searchTerm)) {
                Long id = app.getId();
                return repository.findById(id);
            }
            else {
                return null;
            }
        }
        return null;
    }

}
