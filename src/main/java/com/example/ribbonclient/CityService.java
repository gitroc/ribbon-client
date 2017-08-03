package com.example.ribbonclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(int id) {
        return restTemplate.getForEntity("http://EUREKA-SONG/api/city/" + id, String.class).getBody();
    }
    public String addServiceFallback(int id) {
        return "Ribbon CityService Error id = " + id;
    }
}
