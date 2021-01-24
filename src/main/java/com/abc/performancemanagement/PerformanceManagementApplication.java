package com.abc.performancemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class PerformanceManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerformanceManagementApplication.class, args);
    }
}
