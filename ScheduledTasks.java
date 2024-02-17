package com.example.APITest;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ScheduledTasks {

    @Scheduled(cron = "0 * * * * *") // Runs at the top of every minute
    public void performScheduledTask() {
        System.out.println("Executing scheduled task - " + System.currentTimeMillis() / 1000);
    }

    @PostConstruct
    public void runAtStart() {
        System.out.println("Executing task at application start - " + System.currentTimeMillis() / 1000);
    }
}