package com.example.efinancialadvisor.front.config;

import org.springframework.stereotype.Component;

@Component

public class BackendConfig {

    private String getExpenses (){
        return "http://localhost:8081/v1/budget/expenses/29";
    }
}
