package com.example.efinancialadvisor.front.views;


import com.example.efinancialadvisor.front.domain.Need;
import com.example.efinancialadvisor.front.domain.NeedsService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

@Route("myneeds")
@StyleSheet("/css/background.css")
public class MyNeeds extends HorizontalLayout {

    private NeedsService needsService = NeedsService.getInstance();
    private Button buttonMainScreen = new Button("Main screen", new Icon(VaadinIcon.BACKWARDS), event -> UI.getCurrent().navigate(MainView.class));
    private Grid<Need> grid = new Grid<>(Need.class);

    public MyNeeds() {
        add(buttonMainScreen);
        grid.setColumns("need", "value");
        add(grid);
        setSizeFull();
        refresh();
    }

    public void refresh () {
        grid.setItems(needsService.getNeeds());
    }
}
