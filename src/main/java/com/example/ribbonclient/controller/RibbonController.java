package com.example.ribbonclient.controller;

import com.example.ribbonclient.service.CompanyService;
import com.example.ribbonclient.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RibbonController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private LoanService loanService;

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

    @RequestMapping(value = "/loan/{id}", method = RequestMethod.GET)
    public Object findOne(@PathVariable("id") long id) {
        return loanService.findOne(id);
    }

    @RequestMapping(value = "/loan", method = RequestMethod.GET)
    public Object findList(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                           @RequestParam(value = "loanLimit", required = false, defaultValue = "") long loanLimit) {
        return loanService.findList(page, size, loanLimit);
    }

}
