package com.example.efinancialadvisor.front.views;

import com.example.efinancialadvisor.front.backend.BackendClient;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;


@Route("budgetcalculator")
@StyleSheet("/css/background.css")
public class BudgetCalculator extends VerticalLayout {

    private final BackendClient client = new BackendClient(new RestTemplate());

    private Button buttonPostBudget = new Button();

    private BigDecimal income = new BigDecimal(BigInteger.ZERO);
    private BigDecimal expenses = new BigDecimal(BigInteger.ZERO);
    private BigDecimal netIncome = new BigDecimal(BigInteger.ZERO);

    private TextField textFieldIncome = new TextField();
    private TextField textFieldRent = new TextField();
    private TextField textFieldUtilities = new TextField();
    private TextField textFieldPhone = new TextField();
    private TextField textFieldGas = new TextField();
    private TextField textFieldFood = new TextField();
    private TextField textFieldCosmetics = new TextField();
    private TextField textFieldClothes = new TextField();
    private TextField textFieldEducation = new TextField();
    private TextField textFieldSports = new TextField();
    private TextField textFieldHobby = new TextField();
    private TextField textFieldAlimony = new TextField();
    private TextField textFieldHealthcare = new TextField();
    private TextField textFieldHoliday = new TextField();
    private TextField textFieldCarInsurance = new TextField();
    private TextField textFieldOther = new TextField();
    private TextField textFieldHouseInsurance = new TextField();
    private TextField textFieldPersonalInsurance = new TextField();
    private TextField textFieldLoans = new TextField();

    public BudgetCalculator() {


        textFieldIncome.setTitle("Monthly income");
        textFieldRent.setTitle("Rent");
        textFieldUtilities.setTitle("Utilities");
        textFieldPhone.setTitle("Phone, Internet, TV");
        textFieldGas.setTitle("Ticket/ gas");
        textFieldFood.setTitle("Food and restaurants");
        textFieldCosmetics.setTitle("Cosmetics and beauty products");
        textFieldClothes.setTitle("Clothes");
        textFieldEducation.setTitle("Education");
        textFieldSports.setTitle("Sports");
        textFieldHobby.setTitle("Hobby");
        textFieldAlimony.setTitle("Alimony");
        textFieldHealthcare.setTitle("Healthcare and medications");
        textFieldHoliday.setTitle("Holidays");
        textFieldCarInsurance.setTitle("Car insurance");
        textFieldHouseInsurance.setTitle("House and property insurance");
        textFieldPersonalInsurance.setTitle("Personal insurance");
        textFieldLoans.setTitle("Loans");
        textFieldOther.setTitle("Other expenses");

        textFieldIncome.setLabel("Monthly income");
        textFieldRent.setLabel("Rent");
        textFieldUtilities.setLabel("Utilities");
        textFieldPhone.setLabel("Phone, Internet, TV");
        textFieldGas.setLabel("Ticket/ gas");
        textFieldFood.setLabel("Food and restaurants");
        textFieldCosmetics.setLabel("Cosmetics and beauty products");
        textFieldClothes.setLabel("Clothes");
        textFieldEducation.setLabel("Education");
        textFieldSports.setLabel("Sports");
        textFieldHobby.setLabel("Hobby");
        textFieldAlimony.setLabel("Alimony");
        textFieldHealthcare.setLabel("Healthcare and medications");
        textFieldHoliday.setLabel("Holidays");
        textFieldCarInsurance.setLabel("Car insurance");
        textFieldHouseInsurance.setLabel("House and property insurance");
        textFieldPersonalInsurance.setLabel("Personal insurance");
        textFieldLoans.setLabel("Loans");
        textFieldOther.setLabel("Other expenses");

        add(textFieldRent, textFieldUtilities, textFieldPhone, textFieldGas, textFieldFood, textFieldCosmetics, textFieldClothes, textFieldEducation,
                textFieldSports, textFieldHobby, textFieldAlimony, textFieldHealthcare, textFieldHoliday, textFieldCarInsurance, textFieldHouseInsurance, textFieldPersonalInsurance,textFieldLoans, textFieldOther, buttonPostBudget);

        buttonPostBudget.addClickListener(event -> {
            client.postBudget(textFieldRent.getValue(), textFieldUtilities.getValue(), textFieldPhone.getValue(),
                    textFieldGas.getValue(), textFieldFood.getValue(), textFieldCosmetics.getValue(), textFieldClothes.getValue(),
                    textFieldEducation.getValue(), textFieldSports.getValue(), textFieldHobby.getValue(), textFieldAlimony.getValue(),
                    textFieldHealthcare.getValue(), textFieldHoliday.getValue(), textFieldCarInsurance.getValue(), textFieldHouseInsurance.getValue(),
                    textFieldPersonalInsurance.getValue(), textFieldLoans.getValue(), textFieldOther.getValue());
                });
    }


}
