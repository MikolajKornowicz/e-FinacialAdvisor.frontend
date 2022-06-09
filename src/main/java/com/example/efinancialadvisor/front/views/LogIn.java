package com.example.efinancialadvisor.front.views;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;

import com.vaadin.flow.router.Route;

@Route("")
public class LogIn extends Composite<LoginOverlay> {

    public LogIn() {
        LoginOverlay loginOverlay = getContent();
        loginOverlay.setOpened(true);

        loginOverlay.setTitle("Welcome to HomeApp");
        loginOverlay.setDescription("Mange your household");

        loginOverlay.addLoginListener(event -> {
            if (event.getUsername().equals("admin")&& event.getPassword().equals("admin")){
                UI.getCurrent().navigate(MainView.class);
            } else {
                Notification.show("Invalid credentials");
            }
        });
        loginOverlay.addForgotPasswordListener(event -> {
            Notification.show("Please contact admin");
        });
    }
}