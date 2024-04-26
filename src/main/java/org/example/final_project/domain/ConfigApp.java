package org.example.final_project.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "org.example.final_project.service",
        "org.example.final_project.dao"})
public class ConfigApp {
}
