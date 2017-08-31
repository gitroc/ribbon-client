package com.example.ribbonclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getAllCompany")
    public Object getAll() {
        return restTemplate.getForEntity("http://EUREKA-SONG/api/company/", Object.class).getBody();
    }

    public String getAllCompany() {
        return "Ribbon getAllCompany Error";
    }
}
