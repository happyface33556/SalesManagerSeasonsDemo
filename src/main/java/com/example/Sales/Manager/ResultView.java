package com.example.Sales.Manager;

import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;

@Route("ResultView")
@Tag("result-view")
@JsModule("./src/views/result-view.js")
public class ResultView extends PolymerTemplate<TemplateModel> {
    @Id("header")
    Div header;

    @Id("main")
    Div main;

    @Id("footer")
    Div footer;

    public ResultView() {
        createHeader();
        Inquiry currentInquiry = ComponentUtil.getData(UI.getCurrent(), Inquiry.class);
        Month month = (currentInquiry.getDate()).getMonth();
        String stringMonth = month.toString();
        int hour = currentInquiry.getDate().getHour();
        int lowEnd = 0;
        int highEnd = 0;
        if (Objects.equals(stringMonth, "JANUARY") || Objects.equals(stringMonth, "FEBRUARY") || Objects.equals(stringMonth, "MARCH")
            || Objects.equals(stringMonth, "APRIL") || Objects.equals(stringMonth, "MAY") || Objects.equals(stringMonth, "NOVEMBER")
            || Objects.equals(stringMonth, "DECEMBER")) {
            if (Objects.equals(currentInquiry.getRoom(), "NAPA")) {
                if (hour == 11 || hour == 12 || hour == 1 || hour == 2) {
                    lowEnd = 750;
                    highEnd = 1000;
                }
                if (hour >= 15 && hour < 21) {
                    lowEnd = 1500;
                    highEnd  = 2000;
                }
            }
            if (Objects.equals(currentInquiry.getRoom(), "SONOMA")) {
                if (hour == 11 || hour == 12 || hour == 1 || hour == 2) {
                    lowEnd = 1000;
                    highEnd = 1500;
                }
                if (hour >= 15 && hour < 21) {
                    lowEnd = 2000;
                    highEnd = 2500;
                }
            }
            if (Objects.equals(currentInquiry.getRoom(), "TERRACE")) {
                if (hour == 11 || hour == 12 || hour == 1 || hour == 2) {
                    lowEnd = 3000;
                    highEnd = 4000;
                }
                if (hour >= 15 && hour < 21) {
                    lowEnd = 5000;
                    highEnd = 8000;
                }
            }
        }
        if (Objects.equals(stringMonth, "JUNE") || Objects.equals(stringMonth, "JULY") || Objects.equals(stringMonth, "AUGUST")
            || Objects.equals(stringMonth, "SEPTEMBER") || Objects.equals(stringMonth, "OCTOBER")) {
            if (Objects.equals(currentInquiry.getRoom(), "NAPA")) {
                if (hour == 11 || hour == 12 || hour == 1 || hour == 2) {
                    lowEnd = 500;
                    highEnd = 750;
                }
                if (hour >= 15 && hour < 21) {
                    lowEnd = 1000;
                    highEnd  = 1500;
                }
            }
            if (Objects.equals(currentInquiry.getRoom(), "SONOMA")) {
                if (hour == 11 || hour == 12 || hour == 1 || hour == 2) {
                    lowEnd = 500;
                    highEnd = 1000;
                }
                if (hour >= 15 && hour < 21) {
                    lowEnd = 1250;
                    highEnd = 1500;
                }
            }
            if (Objects.equals(currentInquiry.getRoom(), "TERRACE")) {
                if (hour == 11 || hour == 12 || hour == 1 || hour == 2) {
                    lowEnd = 3000;
                    highEnd = 4000;
                }
                if (hour >= 15 && hour < 21) {
                    lowEnd = 4000;
                    highEnd = 6000;
                }
            }
        }
        Image poss = new Image("images/Screen Shot 2022-02-27 at 8.03.52 PM.png", "possibilities");
        FlexLayout imageLayout = new FlexLayout();
        imageLayout.add(poss);
        imageLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        imageLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        Paragraph response = new Paragraph("Thanks so much for your interest! For your projected date, we" +
                                            " anticipate a Minimum Spend Amount of: $" + lowEnd + " to $" + highEnd +
                                            ". If you would like to reach out to our sales team to discuss further," +
                                            " please press the button below and your information will be forwarded" +
                                            " to a Sales Manager.");
        FlexLayout paraLayout = new FlexLayout();
        Button submit = new Button("Submit Inquiry");
        paraLayout.add(response);
        paraLayout.setAlignContent(FlexLayout.ContentAlignment.CENTER);
        paraLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        FlexLayout buttonLayout = new FlexLayout();
        buttonLayout.add(submit);
        buttonLayout.setAlignContent(FlexLayout.ContentAlignment.CENTER);
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        main.add(imageLayout);
        main.add(paraLayout);
        main.add(buttonLayout);
    }

    public void createHeader() {
        Image logo = new Image("images/og-logo.jpeg", "logo");
        logo.setWidth(150, Unit.PIXELS);
        header.add(logo);
    }
}
