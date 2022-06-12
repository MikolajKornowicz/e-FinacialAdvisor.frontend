package com.example.efinancialadvisor.front.backend;

import com.example.efinancialadvisor.front.domain.BudgetDto;
import com.example.efinancialadvisor.front.domain.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Component
@RequiredArgsConstructor
public class BackendClient {


    private final RestTemplate restTemplate;

    private String backendApiEndPoint = "http://localhost:8081/v1/budget";
    private String backendUserId = "/29";

    public BudgetDto getBudget (){

        URI url = UriComponentsBuilder.fromHttpUrl(backendApiEndPoint + backendUserId)
                .build().encode().toUri();
        BudgetDto budgetResponse = restTemplate.getForObject(url, BudgetDto.class);

        return budgetResponse;
    }

    public void postBudget (String rent, String utilities, String phone, String gas, String food, String cosmetics,
                            String clothes, String education, String sports, String hobby, String alimony, String healthcare,
                            String holidays, String carInsurance, String houseInsurance, String personalInsurance, String loans, String other){

        BudgetDto budgetDto = new BudgetDto();
        budgetDto.setUserId(33L);
        budgetDto.setRent(Integer.parseInt(rent));
        budgetDto.setUtilities(Integer.parseInt(utilities));
        budgetDto.setPhone(Integer.parseInt(phone));
        budgetDto.setGas(Integer.parseInt(gas));
        budgetDto.setFood(Integer.parseInt(food));
        budgetDto.setCosmetics(Integer.parseInt(cosmetics));
        budgetDto.setClothes(Integer.parseInt(clothes));
        budgetDto.setEducation(Integer.parseInt(education));
        budgetDto.setSports(Integer.parseInt(sports));
        budgetDto.setHobby(Integer.parseInt(hobby));
        budgetDto.setAlimony(Integer.parseInt(alimony));
        budgetDto.setHealthcare(Integer.parseInt(healthcare));
        budgetDto.setHolidays(Integer.parseInt(holidays));
        budgetDto.setCar_insurance(Integer.parseInt(carInsurance));
        budgetDto.setHouse_insurance(Integer.parseInt(houseInsurance));
        budgetDto.setPersonal_insurance(Integer.parseInt(personalInsurance));
        budgetDto.setLoans(Integer.parseInt(loans));
        budgetDto.setOther(Integer.parseInt(other));

        restTemplate.postForObject("http://localhost:8081/v1/budget", budgetDto, BudgetDto.class);
    }

    public String getCredentials(UserDto userDto){
        String reply = restTemplate.postForObject("http://localhost:8081/v1/budget/login", userDto, UserDto.class).toString();
        System.out.println(reply);
        return reply;
    }
}
