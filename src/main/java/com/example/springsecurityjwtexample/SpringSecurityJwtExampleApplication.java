package com.example.springsecurityjwtexample;

import com.example.springsecurityjwtexample.entity.User;
import com.example.springsecurityjwtexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

    @Autowired
    private UserRepository repository;




        public static void main (String[]args){
            SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
        }

}
