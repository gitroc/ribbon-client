package com.example.ribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public Object findOneCity(@PathVariable("id") int id) {
        return cityService.addService(id);
    }

    @RequestMapping(value = "/api/company", method = RequestMethod.GET)
    public Object findAll() {
        return companyService.getAll();
    }
}
