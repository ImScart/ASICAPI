package com.example.APITest;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.APITest.APIModels.Miner;
import com.example.APITest.APIModels.Sia;
import com.example.APITest.APIModels.SiaPriceRoot;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonDataService {
    private JsonData jsonData = new JsonData();

    public JsonData getJsonData() {
        return jsonData;
    }

    public void updateJsonData() {
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

            jsonData.setRevenue(revenue);
            jsonData.setCost(cost);
            jsonData.setProfit(revenue - cost);
            jsonData.setLastUpdateTime();
            jsonData.setNextUpdateTime();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}