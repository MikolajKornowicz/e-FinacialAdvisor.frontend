package com.example.efinancialadvisor.front.views;

import com.example.efinancialadvisor.front.backend.BackendClient;
import com.example.efinancialadvisor.front.service.Authenticator;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;


@Route("")
public class LogIn extends Div {

    private H1 welcome = new H1("Welcome");
    private Button buttonNewAccount = new Button("Create new account", event -> UI.getCurrent().navigate(CreateNewAccount.class));
    private Button buttonForgotPassword = new Button("Forgot Password");
    private Button buttonLogIn = new Button("LogIn", event -> UI.getCurrent().navigate(MainView.class));
    private TextField textFieldUsername = new TextField();
    private TextField textFieldPassword = new TextField();

    private BackendClient client = new BackendClient(new RestTemplate());
    private Authenticator authenticator = new Authenticator(client);

    public LogIn (){

        setId("login-view");
        add(welcome, textFieldUsername, textFieldPassword);
        add(buttonLogIn, buttonNewAccount, buttonForgotPassword);
        textFieldUsername.setLabel("Username");
        textFieldPassword.setLabel("Password");

        buttonLogIn.addClickListener(event -> {
            if(authenticator.authenticate(textFieldUsername.getValue())){
                UI.getCurrent().navigate(MainView.class);
            } else {
                new Notification("Invalid username or password");
            }
        });
    }
}