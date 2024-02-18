package com.example.APITest;

import com.example.APITest.APIModels.Miner;
import com.example.APITest.APIModels.Sia;
import com.example.APITest.APIModels.SiaPriceRoot;

public class getData {
    public static Double getOverallHashrate(Miner dataList) {
        Double hashrate = 0.0;
        for (int i = 0; i < dataList.data.size(); i++) {
            hashrate += dataList.data.get(i).av_hashrate;
        }
        return hashrate;
    }

    public static Double getRewardPerDay(Miner minerData, SiaPriceRoot siaPriceData, Sia siaData) {
        Double miningPowerInHs = getOverallHashrate(minerData) * 1e6;
        Double revenueCoinPerDay = ((miningPowerInHs / Double.parseDouble(siaData.difficulty)) * 86400)
                * siaData.block_reward;
        return (revenueCoinPerDay * siaPriceData.siacoin.cad);
    }

    public static Double getElectricityCost(int watts, Double costKwh) {
        return ((watts * 24) / 1000) * costKwh;
    }
}