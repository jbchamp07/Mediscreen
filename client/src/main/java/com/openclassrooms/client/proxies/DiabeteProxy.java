package com.openclassrooms.client.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-diabete", url = "localhost:9003")
public interface DiabeteProxy {

    @GetMapping("/assess")
    String assess(@RequestParam int patientId);
    @GetMapping("/assessName")
    String assessName(@RequestParam String familyName);

}
