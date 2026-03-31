package com.catmanscodes.springboot_aws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Home Page!";
    }

    @GetMapping("/info")
    public String info() {

        String javaVersion = System.getProperty("java.version");
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");

        return "Application Information:\n" + "Java Version: "
                + javaVersion + "\n" + "Operating System: "
                + osName + " " + osVersion;

    }
}
