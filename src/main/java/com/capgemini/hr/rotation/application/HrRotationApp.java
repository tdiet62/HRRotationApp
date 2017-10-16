package com.capgemini.hr.rotation.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"com.capgemini.hr.rotation.config"}
)
public class HrRotationApp {
    public HrRotationApp() {
    }

    public static void main(String[] args) {
        SpringApplication.run(HrRotationApp.class);
    }
}

//Main-Class: com.capgemini.hr.rotation.application.HrRotationApp