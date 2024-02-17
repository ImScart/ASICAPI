package com.example.APITest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation marks the class as a controller where every method returns a
                // domain object instead of a view.
public class RoutesController {

    @GetMapping("/APItest") // Maps the root URL to this method.
    public JsonData helloWorld() {
        return new JsonData("Ceci est un test de String en Json");
    }
}