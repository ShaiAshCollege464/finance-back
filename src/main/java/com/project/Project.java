package com.project;


import com.project.Utils.CustomLogger;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class
})
@EnableScheduling
public class Project {
    public static boolean applicationStarted = false;
    private static final CustomLogger LOGGER = new CustomLogger(Project.class);
    public static long startTime;

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Jerusalem"));
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Project.class, args);
        LOGGER.log("Application started.");
        applicationStarted = true;
        startTime = System.currentTimeMillis();
    }

}