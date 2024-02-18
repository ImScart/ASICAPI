package com.example.APITest;

public class JsonData {
    private String lastUpdateTime;
    private String nextUpdateTime;
    private Double revenue;
    private Double cost;
    private Double profit;

    public JsonData() {

    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime() {
        lastUpdateTime = getCurrentUnix();
    }

    public String getNextUpdateTime() {
        return nextUpdateTime;
    }

    public void setNextUpdateTime() {
        nextUpdateTime = getNextUnix();
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public static String getCurrentUnix() {
        String ut2 = Long.toString(System.currentTimeMillis() / 1000L);
        return ut2;
    }

    public static String getNextUnix() {
        String ut2 = Long.toString((System.currentTimeMillis() / 1000L) + 120); // for updates every 2 minutes
        return ut2;
    }
}