package com.example.efinancialadvisor.front.mapper;

import com.example.efinancialadvisor.front.domain.BudgetDto;
import com.example.efinancialadvisor.front.domain.Profile;

public class ProfileMapper {

    public Profile mapBudgetToProfile(BudgetDto budgetDto){
        return new Profile(
                budgetDto.getUserId(),
                budgetDto.getUsername(),
                budgetDto.getPassword(),
                budgetDto.getEmail(),
                budgetDto.getName(),
                budgetDto.getSurname()
        );
    }
}
