package com.openclassrooms.client.proxies;

import com.openclassrooms.client.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-patient", url = "localhost:9001")
public interface PatientProxy {

    @GetMapping(value = "/patient")
    List<PatientBean> PatientsList();

    @GetMapping( value = "/patient/{id}")
    PatientBean aPatient(@PathVariable("id") int id);

    @PostMapping(value = "/patient")
    void add(@RequestBody PatientBean patient);

    @PutMapping(value = "/patient")
    void update(@RequestBody PatientBean patient);

    @DeleteMapping(value = "/patient")
    void delete(@PathVariable int patientId);
}
