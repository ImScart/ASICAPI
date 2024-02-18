package com.example.APITest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ScheduledTasks {

    @Autowired
    private JsonDataService jsonDataService;

    @Scheduled(cron = "0 */2 * * * *")
    public void performTask() {
        jsonDataService.updateJsonData(); // modifier avec bonnes informations chaque 2 minutes
        System.out.println("Updated JsonData");
    }

    @PostConstruct
    public void runAtStart() {
        jsonDataService.updateJsonData();
    }
}
