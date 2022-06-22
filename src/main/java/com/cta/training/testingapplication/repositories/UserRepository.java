package com.cta.training.testingapplication.repositories;

import com.cta.training.testingapplication.application.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
