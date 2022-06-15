package com.example.efinancialadvisor.front.domain;

import com.vaadin.flow.component.dependency.StyleSheet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profile {

    private Long userId;
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;


}
