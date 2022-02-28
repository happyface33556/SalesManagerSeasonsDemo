package com.example.Sales.Manager;

import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route("RoomOptionView")
@Tag("room-view")
@JsModule("./src/views/room-view.js")
public class RoomView extends PolymerTemplate<TemplateModel> {
    @Id("header")
    Div header;

    @Id("main")
    Div main;

    @Id("footer")
    Div footer;

    public RoomView() {
        createHeader();

        FlexLayout titleLayout = new FlexLayout();
        FlexLayout paraLayout = new FlexLayout();
        Image rooms = new Image("images/rooms.png", "rooms");
        Paragraph paragraph = new Paragraph(
                "Whether it's for business or pleasure, we will help you host"
                        + " an event as effortless as it is memorable. Our well-appointed"
                        + " private dining rooms are comfortable, welcoming spaces to accommodate"
                        + " up to 76 guests. Select from one of our options below!");
        titleLayout.add(rooms);
        paraLayout.add(paragraph);
        titleLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        titleLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        paraLayout.setAlignContent(FlexLayout.ContentAlignment.CENTER);
        paraLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        main.add(titleLayout);
        main.add(paraLayout);

        Div cardList = new Div();
        cardList.addClassName("card-list");
        ExCard card;

        card = new ExCard("NAPA");
        Image napa = new Image("images/Napa Room.jpg", "Napa Room");
        napa.setWidth(250, Unit.PIXELS);
        card.add(napa, new UnorderedList(new ListItem("Up to 40 guests"),
                new ListItem("LCD projection capabilities"),
                new ListItem("Expandable space")));
        Button napaButton = new Button("Get started");
        card.add(napaButton);
        napaButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cardList.add(card);

        card = new ExCard("SONOMA");
        Image sonoma = new Image("images/Sonoma Room.jpg", "Sonoma Room");
        sonoma.setWidth(250, Unit.PIXELS);
        card.add(sonoma, new UnorderedList(new ListItem("Up to 36 guests"),
                new ListItem("Stunning lakefront view"),
                new ListItem("LCD projection capabilities")));
        Button sonomaButton = new Button("Get started");
        sonomaButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        card.add(sonomaButton);
        cardList.add(card);

        card = new ExCard("TERRACE");
        Image terrace = new Image("images/SLR Terrace.jpg", "Terrace");
        terrace.setWidth(250, Unit.PIXELS);
        card.add(terrace, new UnorderedList(new ListItem("Up to 80 guests"),
                new ListItem("Stunning lakefront view"),
                new ListItem("LCD projection capabilities")));
        Button terraceButton = new Button("Get started");
        terraceButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        card.add(terraceButton);
        cardList.add(card);

        main.add(cardList);
        napaButton.addClickListener(e -> {
            UI.getCurrent().navigate("NapaForm");
        });
        sonomaButton.addClickListener(e -> {
            UI.getCurrent().navigate("SonomaForm");
        });
        terraceButton.addClickListener(e -> {
            UI.getCurrent().navigate("TerraceForm");
        });
    }

    public void createHeader() {
        Image logo = new Image("images/og-logo.jpeg", "logo");
        logo.setWidth(150, Unit.PIXELS);
        header.add(logo);
    }
}
