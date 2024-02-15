package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonFetcher {
    public static String getJsonFromUrl(String urlString) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result.toString();
    }
}