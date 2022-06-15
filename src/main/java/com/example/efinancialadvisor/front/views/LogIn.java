package com.example.efinancialadvisor.front.views;

import com.example.efinancialadvisor.front.backend.BackendClient;
import com.example.efinancialadvisor.front.domain.BudgetDto;
import com.example.efinancialadvisor.front.domain.Profile;
import com.example.efinancialadvisor.front.domain.UserDto;
import com.example.efinancialadvisor.front.mapper.ProfileMapper;
import com.example.efinancialadvisor.front.service.Authenticator;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;

import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;


@Route("")
@StyleSheet("src/main/resources/css/background.css")
public class LogIn extends Div {

    private H1 welcome = new H1("Welcome");
    private Button buttonNewAccount = new Button("Create new account", event -> UI.getCurrent().navigate(CreateNewAccount.class));
    private Button buttonForgotPassword = new Button("Forgot Password");
    private Button buttonLogIn = new Button("LogIn");
    private TextField textFieldUsername = new TextField();
    private TextField textFieldPassword = new TextField();
    private Notification notification = new Notification();
    public static Profile profile = new Profile();


    private BackendClient client = new BackendClient(new RestTemplate());
    private Authenticator authenticator = new Authenticator(client);
    private ProfileMapper mapper = new ProfileMapper();

    public LogIn (){

        setId("login-view");
        add(welcome, textFieldUsername, textFieldPassword);
        add(buttonLogIn, buttonNewAccount, buttonForgotPassword);
        textFieldUsername.setLabel("Username");
        textFieldPassword.setLabel("Password");
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        Div text = new Div(new Text("Invalid username or password"));

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(event -> {
            notification.close();
        });
        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        notification.add(layout);

        buttonLogIn.addClickListener(event -> {
            String username = textFieldUsername.getValue();
            String password = textFieldPassword.getValue();
            UserDto user = new UserDto(username, password);
            if(client.getCredentials(user).getUsername().equals("UnknownUser")){
               add(notification);
               notification.open();
            } else {
                UI.getCurrent().navigate(MainView.class);
                BudgetDto budgetDto = client.getBudgetByUsername(textFieldUsername.getValue());
                profile.setUsername(mapper.mapBudgetToProfile(budgetDto).getUsername());
                profile.setUserId(mapper.mapBudgetToProfile(budgetDto).getUserId());
                profile.setPassword(mapper.mapBudgetToProfile(budgetDto).getPassword());
                profile.setEmail(mapper.mapBudgetToProfile(budgetDto).getEmail());
                profile.setName(mapper.mapBudgetToProfile(budgetDto).getName());
                profile.setSurname(mapper.mapBudgetToProfile(budgetDto).getSurname());
            }
        });
    }
}