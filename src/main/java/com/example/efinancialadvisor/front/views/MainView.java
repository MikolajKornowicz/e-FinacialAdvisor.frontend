package com.example.efinancialadvisor.front.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("myMoney")
@StyleSheet("/css/background.css")
public class MainView extends HorizontalLayout {

    Button buttonNeeds = new Button("My financial needs", event -> UI.getCurrent().navigate(MyNeeds.class));
    Button buttonBudget = new Button("My Budget", new Icon(VaadinIcon.WALLET), event -> UI.getCurrent().navigate(Budget.class));
    public MainView() {
        add(buttonNeeds, buttonBudget);
    }
}
