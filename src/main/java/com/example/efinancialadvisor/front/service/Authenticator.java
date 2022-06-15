package com.example.efinancialadvisor.front.service;

import com.example.efinancialadvisor.front.backend.BackendClient;
import com.example.efinancialadvisor.front.domain.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Authenticator {

    private BackendClient client;

    public boolean authenticate (UserDto userDto){
        return !client.getCredentials(userDto).getUsername().equals("UnknownUser") && client.getCredentials(userDto).getPassword().equals("UnknownUser");
    }
}
