package com.example.efinancialadvisor.front.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("newAccount")
public class CreateNewAccount extends VerticalLayout {


    private TextField textFieldUsername = new TextField("Username");
    private TextField textFieldPassword = new TextField("Password");
    private TextField textFieldEmail = new TextField("Email");
    private TextField textFieldName = new TextField("Name");
    private TextField textFieldSurname = new TextField("Surname");

    public CreateNewAccount() {

        add(textFieldUsername, textFieldPassword, textFieldEmail,  textFieldName, textFieldSurname);
    }

}
