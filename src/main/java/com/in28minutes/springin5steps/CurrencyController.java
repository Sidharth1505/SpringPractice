package com.in28minutes.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {
    @Autowired
    private CurrencyConfiguration currencyConfiguration;

    @RequestMapping("/currency-configuration")
    public CurrencyConfiguration getCurrencyConfiguration() {
        return currencyConfiguration;
    }
}
