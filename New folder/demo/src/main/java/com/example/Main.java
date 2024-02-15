package com.example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.example.APIModels.Miner;
import com.example.APIModels.Sia;
import com.example.APIModels.SiaPriceRoot;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    private static LocalDateTime lastUpdateTime = LocalDateTime.now();

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(Main::updateAndDisplayData, 0, 1, TimeUnit.MINUTES);
    }

    public static void updateAndDisplayData() {
        LocalDateTime now = LocalDateTime.now();
        long minutesUntilNextUpdate = 1 - ChronoUnit.MINUTES.between(lastUpdateTime, now) % 1;
        System.out.println("Time until next update: " + minutesUntilNextUpdate + " minutes");
        lastUpdateTime = now;

        String miningUrl = "http://192.168.2.57/mcb/cgminer?cgminercmd=devs";
        String siaUrl = "https://siamining.com/api/v1/network";
        String siaPriceUrl = "https://api.coingecko.com/api/v3/simple/price?ids=Siacoin&vs_currencies=cad";
        
        try {
            String miningJsonString = JsonFetcher.getJsonFromUrl(miningUrl);
            String siaJsonString = JsonFetcher.getJsonFromUrl(siaUrl);
            String siaPriceJsonString = JsonFetcher.getJsonFromUrl(siaPriceUrl);

            ObjectMapper mapper = new ObjectMapper();
            Miner minerRoot = mapper.readValue(miningJsonString, Miner.class);
            SiaPriceRoot siaPriceRoot = mapper.readValue(siaPriceJsonString, SiaPriceRoot.class);
            Sia siaRoot = mapper.readValue(siaJsonString, Sia.class);

            Double revenue = getData.getRewardPerDay(minerRoot, siaPriceRoot, siaRoot);
            Double cost = getData.getElectricityCost(1500, 0.1);

            System.out.println("Revenue: " + revenue);
            System.out.println("Cost: " + cost);
            System.out.println("Profit: " + (revenue - cost));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
