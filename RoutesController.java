package com.example.APITest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutesController {

    @Autowired
    private JsonDataService jsonDataService;

    @GetMapping("/APItest")
    public JsonData apiStuff() {
        return jsonDataService.getJsonData();
    }
}