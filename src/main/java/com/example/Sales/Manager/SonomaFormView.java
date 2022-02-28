package com.example.Sales.Manager;

import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

@Route("SonomaForm")
@Tag("sonoma-view")
@JsModule("./src/views/sonoma-view.js")
public class SonomaFormView extends PolymerTemplate<TemplateModel> {
    @Id("header")
    Div header;

    @Id("main")
    Div main;

    @Id("footer")
    Div footer;

    private InquiryRepo repo;

    public SonomaFormView(InquiryRepo repo) {
        createHeader();

        FlexLayout titleLayout = new FlexLayout();
        FlexLayout imageLayout = new FlexLayout();
        Image cocktailHour = new Image("images/GroupDining-h-920x406.jpeg", "cocktail-hour");
        Image planning = new Image("images/planning.png", "planning");

        titleLayout.add(planning);
        titleLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        titleLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        imageLayout.add(cocktailHour);
        imageLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        imageLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        EmailField validEmailField = new EmailField();
        validEmailField.setLabel("Email address");
        validEmailField.getElement().setAttribute("name", "email");
        validEmailField.setPlaceholder("julia.scheider@email.com");
        validEmailField.setErrorMessage("Please enter a valid email address");
        validEmailField.setClearButtonVisible(true);

        TextField numGuests = new TextField("Number of Guests In Your Party?");
        numGuests.setPlaceholder("No more than 36");

        DateTimePicker dateTimePicker = new DateTimePicker();
        dateTimePicker.setLabel("When Do You Wish To Dine?");
        dateTimePicker.setHelperText("11:30 AM - 8:00 PM");
        dateTimePicker.setAutoOpen(true);

        List<String> purposes = new Vector<>();
        purposes.add("Business");
        purposes.add("Personal");
        purposes.add("Bridal");
        purposes.add("Other");
        ComboBox<String> purposeSelect = new ComboBox<>("Purpose For Group/Private Dining?", purposes);
        purposeSelect.setPlaceholder("SELECT A PURPOSE");

        Button submitButton = new Button("Submit");

        FlexLayout buttonLayout = new FlexLayout();
        buttonLayout.add(submitButton);
        buttonLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        FormLayout formLayout = new FormLayout();
        formLayout.add(
                firstName, lastName,
                validEmailField,
                numGuests, purposeSelect,
                dateTimePicker
        );
        formLayout.setResponsiveSteps(
                // Use one column by default
                new FormLayout.ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 500px
                new FormLayout.ResponsiveStep("500px", 2)
        );
// Stretch the username field over 2 columns
        formLayout.setColspan(validEmailField, 2);
        formLayout.setColspan(dateTimePicker, 2);
        main.add(titleLayout, imageLayout, formLayout, buttonLayout);
        submitButton.addClickListener(e -> {
            String room = "SONOMA";
            int guestCount = Integer.parseInt(numGuests.getValue());
            String purpose = purposeSelect.getValue();
            LocalDateTime date = dateTimePicker.getValue();
            Inquiry newInquiry = new Inquiry(firstName.getValue(), lastName.getValue(),
                    validEmailField.getValue(), guestCount,
                    purpose, date, room);
            ComponentUtil.setData(UI.getCurrent(), Inquiry.class, newInquiry);
            UI.getCurrent().navigate("ResultView");
        });
    }

    public void createHeader() {
        Image logo = new Image("images/og-logo.jpeg", "logo");
        logo.setWidth(150, Unit.PIXELS);
        header.add(logo);
    }
}
