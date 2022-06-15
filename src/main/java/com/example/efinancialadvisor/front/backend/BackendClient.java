package com.example.efinancialadvisor.front.backend;

import com.example.efinancialadvisor.front.domain.BudgetDto;
import com.example.efinancialadvisor.front.domain.Profile;
import com.example.efinancialadvisor.front.domain.UserDto;
import com.example.efinancialadvisor.front.views.LogIn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;


@Component
@RequiredArgsConstructor
public class BackendClient {



    private final RestTemplate restTemplate;

    private String backendApiEndPoint = "http://localhost:8081/v1/budget";


    public BudgetDto getBudget (){

        URI url = UriComponentsBuilder.fromHttpUrl(backendApiEndPoint + "/" + LogIn.profile.getUserId().toString())
                .build().encode().toUri();
        BudgetDto budgetResponse = restTemplate.getForObject(url, BudgetDto.class);

        return budgetResponse;
    }

    public String getExpenses (){

        URI url = UriComponentsBuilder.fromHttpUrl(backendApiEndPoint + "/expenses/" + LogIn.profile.getUserId().toString())
                .build().encode().toUri();

        return restTemplate.getForObject(url, String.class);
    }

    public String getNetIncome (){

        URI url = UriComponentsBuilder.fromHttpUrl(backendApiEndPoint + "/netincome/" + LogIn.profile.getUserId().toString())
                .build().encode().toUri();

        return restTemplate.getForObject(url, String.class);
    }


    public void postBudget (String income, String rent, String utilities, String phone, String gas, String food, String cosmetics,
                            String clothes, String education, String sports, String hobby, String alimony, String healthcare,
                            String holidays, String carInsurance, String houseInsurance, String personalInsurance, String loans, String other){

        BudgetDto budgetDto = new BudgetDto();
        budgetDto.setUserId(LogIn.profile.getUserId());
        budgetDto.setIncome(Integer.parseInt(income));
        budgetDto.setExpenses(Integer.parseInt(getExpenses()));
        budgetDto.setNetIncome(Integer.parseInt(getNetIncome()));
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
        budgetDto.setUsername(LogIn.profile.getUsername());
        budgetDto.setPassword(LogIn.profile.getPassword());
        budgetDto.setEmail(LogIn.profile.getEmail());
        budgetDto.setName(LogIn.profile.getName());
        budgetDto.setSurname(LogIn.profile.getSurname());
        restTemplate.postForObject("http://localhost:8081/v1/budget", budgetDto, BudgetDto.class);
    }

    public UserDto getCredentials(UserDto userDto){
        UserDto user = Objects.requireNonNull(restTemplate.postForObject("http://localhost:8081/v1/budget/login", userDto, UserDto.class));
        return user;
    }

    public BudgetDto getBudgetByUsername(String username){
        BudgetDto budgetDto = restTemplate.getForObject("http://localhost:8081/v1/budget/user/" + username, BudgetDto.class);
        return budgetDto;
    }
}
