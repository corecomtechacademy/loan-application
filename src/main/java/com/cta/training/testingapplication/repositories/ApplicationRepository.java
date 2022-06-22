package com.cta.training.testingapplication.repositories;

import com.cta.training.testingapplication.application.Application;
import org.springframework.data.repository.CrudRepository;


public interface ApplicationRepository extends CrudRepository<Application, Long> {

}