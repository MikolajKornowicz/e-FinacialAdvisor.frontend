package com.example.efinancialadvisor.front.views;

import com.example.efinancialadvisor.front.backend.BackendClient;
import com.example.efinancialadvisor.front.config.BackendConfig;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Route("budget")
@StyleSheet("/css/background.css")
public class Budget extends HorizontalLayout {

    private final BackendClient client = new BackendClient(new RestTemplate());
    private Button buttonCalculator = new Button("Go to calculator", new Icon(VaadinIcon.CALC), event -> UI.getCurrent().navigate(BudgetCalculator.class));
    private Label labelIncome = new Label();
    private Label labelExpenses = new Label();
    private Label labelNetIncome = new Label();
    private BudgetCalculator budgetCalculator;
    private Button getData = new Button("Get data", new Icon(VaadinIcon.ADD_DOCK));


    public Budget() {

        labelIncome.setText("Your monthly income: " + client.getBudget().getIncome());
        labelExpenses.setText("Your monthly expense: " + client.getBudget().getExpenses());
        labelNetIncome.setText("Your monthly net income: " + client.getBudget().getNetIncome());
        add(buttonCalculator, labelIncome, labelExpenses, labelNetIncome, getData);
    }

}
