package com.example.ribbonclient.controller;

import com.example.ribbonclient.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RibbonController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public Object findOne(@PathVariable("id") int id) {
        return companyService.findOne(id);
    }

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public Object findList(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                           @RequestParam(value = "updateTime", required = false, defaultValue = "") String updateTime) {
        return companyService.findList(page, size, updateTime);
    }

}
