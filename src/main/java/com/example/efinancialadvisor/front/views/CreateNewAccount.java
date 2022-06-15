package com.example.efinancialadvisor.front.views;

import com.example.efinancialadvisor.front.backend.BackendClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

import java.awt.*;


@Route("newAccount")
public class CreateNewAccount extends VerticalLayout {

    private BackendClient client = new BackendClient(new RestTemplate());

    private TextField textFieldUsername = new TextField("Username");
    private TextField textFieldPassword = new TextField("Password");
    private TextField textFieldEmail = new TextField("Email");
    private TextField textFieldName = new TextField("Name");
    private TextField textFieldSurname = new TextField("Surname");
    private Button buttonSubmit = new Button("Create new account");

    public CreateNewAccount() {

        add(textFieldUsername, textFieldPassword, textFieldEmail,  textFieldName, textFieldSurname, buttonSubmit);

        buttonSubmit.addClickListener(event -> {
            client.postBudget(textFieldUsername.getValue(), textFieldPassword.getValue(), textFieldEmail.getValue(), textFieldName.getValue(), textFieldSurname.getValue());
        });
    }

}
