package com.openclassrooms.client.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The interface Diabete proxy.
 */
@FeignClient(name = "microservice-diabete", url = "diabetes:9003")
public interface DiabeteProxy {

    /**
     * Assess string.
     *
     * @param patientId the patient id
     * @return the string
     */
    @GetMapping("/assess")
    String assess(@RequestParam int patientId);

    /**
     * Assess name string.
     *
     * @param familyName the family name
     * @return the string
     */
    @GetMapping("/assessName")
    String assessName(@RequestParam String familyName);

}
