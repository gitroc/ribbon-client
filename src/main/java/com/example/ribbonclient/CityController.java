package com.example.ribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
//    public String findOneCity(@PathVariable("id") int id) {
//        return restTemplate.getForEntity("http://EUREKA-SONG/api/city/" + id, String.class).getBody();
//    }
    @Autowired
    private CityService cityService;
    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public String findOneCity(@PathVariable("id") int id) {
        return cityService.addService(id);
    }
}
