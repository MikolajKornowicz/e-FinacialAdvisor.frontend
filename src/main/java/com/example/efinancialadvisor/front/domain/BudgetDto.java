package com.example.efinancialadvisor.front.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BudgetDto {

    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("income")
    private int income;
    @JsonProperty("expenses")
    private int expenses;
    @JsonProperty("netIncome")
    private int netIncome;
    @JsonProperty("rent")
    private int rent;
    @JsonProperty("utilities")
    private int utilities;
    @JsonProperty("phone")
    private int phone;
    @JsonProperty("gas")
    private int gas;
    @JsonProperty("food")
    private int food;
    @JsonProperty("cosmetics")
    private int cosmetics;
    @JsonProperty("clothes")
    private int clothes;
    @JsonProperty("education")
    private int education;
    @JsonProperty("sports")
    private int sports;
    @JsonProperty("hobby")
    private int hobby;
    @JsonProperty("alimony")
    private int alimony;
    @JsonProperty("healthcare")
    private int healthcare;
    @JsonProperty("holidays")
    private int holidays;
    @JsonProperty("car_insurance")
    private int car_insurance;
    @JsonProperty("house_insurance")
    private int house_insurance;
    @JsonProperty("personal_insurance")
    private int personal_insurance;
    @JsonProperty("loans")
    private int loans;
    @JsonProperty("other")
    private int other;



}
