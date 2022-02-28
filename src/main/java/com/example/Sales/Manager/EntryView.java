package com.example.Sales.Manager;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.Objects;
import java.util.Vector;

@Route("")
public class EntryView extends VerticalLayout {

    public EntryView() {
        List<String> locations = new Vector<String>();
        locations.add("Altamonte Springs");
        locations.add("Boca Raton");
        locations.add("Coral Gables");
        locations.add("Fort Lauderdale");
        locations.add("Jacksonville");
        locations.add("Naples");
        locations.add("Orlando - Sand Lake Road");
        locations.add("Palm Beach Gardens");
        locations.add("Sarasota");
        locations.add("Sunrise - Sawgrass");
        locations.add("Tampa");
        ComboBox<String> locationSelect = new ComboBox<>("Location", locations);
        locationSelect.setPlaceholder("Select location");
        Image headerImage = new Image("images/group-dining-header-921x286.jpeg", "Group Dining Header");
        Image logoImage = new Image("images/og-logo.jpeg", "Logo");
        Button continueButton = new Button("Continue");
        logoImage.setWidth(621, Unit.PIXELS);
        add(logoImage,
                headerImage,
                new HorizontalLayout(locationSelect),
                continueButton);
        setHeightFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        locationSelect.addValueChangeListener(event -> {
            String location = locationSelect.getValue();
            if (Objects.equals(location, "Orlando - Sand Lake Road")) {
                continueButton.addClickListener(e -> {
                    UI.getCurrent().navigate("RoomOptionView");
                });
            }
        });

    }
}
