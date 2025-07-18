package com.bytesquad.view_pages.ExplorePage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NaveBar {

public static HBox createNavbar() {
    HBox navbar = new HBox();
    navbar.setPadding(new Insets(12, 20, 12, 20));
    navbar.setSpacing(15);
    navbar.setAlignment(Pos.CENTER_LEFT);
    navbar.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #E5E5E5; -fx-border-width: 0 0 1 0;");


    Label appName = new Label("StoryForge");
    appName.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
    appName.setTextFill(Color.web("#02664E"));

    HBox logoBox = new HBox(8, appName);
    logoBox.setAlignment(Pos.CENTER_LEFT);

    // 🔍 Search Bar shifted immediately right to logo
TextField searchBar = new TextField();
searchBar.setPromptText("Search projects, books, or creators...");
searchBar.setPrefWidth(320);
searchBar.setStyle(
    "-fx-background-color: #FFFFFF; " +                       // white background
    "-fx-background-radius: 20; " +                           // smooth rounded corners
    "-fx-border-radius: 20; " +
    "-fx-border-color: rgba(0,0,0,0.15); " +                  // subtle light black border
    "-fx-border-width: 1.2; " +
    "-fx-padding: 8 15 8 15; " +                               // balanced padding
    "-fx-font-size: 14px; " +                                  // slightly bigger font
    "-fx-text-fill: grey; " +                                 // black input text
    "-fx-prompt-text-fill: black; " +                          // black prompt text
    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.05), 3, 0, 0, 1);" // subtle shadow for depth
);


    // 🧑 Profile Circle with Initials, smaller and simpler
    Circle profileCircle = new Circle(16, Color.web("#48F8C0"));
    Label initials = new Label("PP");
    initials.setTextFill(Color.WHITE);
    initials.setFont(Font.font("Segoe UI", FontWeight.BOLD, 12));

    StackPane profileStack = new StackPane(profileCircle, initials);

    Button creativeZoneButton = new Button("Creative Zone");
    creativeZoneButton.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 13));
    creativeZoneButton.setTextFill(Color.WHITE);
    creativeZoneButton.setStyle(
    "-fx-background-color: #aeecfcff;" +           // brand green
    "-fx-background-radius: 20;" +               // rounded corners
    "-fx-border-radius: 20;" +
    "-fx-padding: 6 18 6 18;" +                   // vertical and horizontal padding
    "-fx-cursor: hand;"+
    "-fx-text-fill: black; "                           // hand cursor on hover
);

creativeZoneButton.setEffect(new DropShadow(5, Color.rgb(0, 0, 0, 0.1)));

    Button recomendButton = new Button("Recomendation");
    recomendButton.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 13));
recomendButton.setTextFill(Color.WHITE);
recomendButton.setStyle(
    "-fx-background-color: #aeecfcff;" +           // brand green
    "-fx-background-radius: 20;" +               // rounded corners
    "-fx-border-radius: 20;" +
    "-fx-padding: 6 18 6 18;" +                   // vertical and horizontal padding
    "-fx-cursor: hand;"+
    "-fx-text-fill: black; "                      
);

// Optional: subtle drop shadow
recomendButton.setEffect(new DropShadow(5, Color.rgb(0, 0, 0, 0.1)));





    Region spacer = new Region();
    HBox.setHgrow(spacer, Priority.ALWAYS);

    Region spacer2 = new Region();
    spacer2.setPrefWidth(55);

        Region spacer3 = new Region();
    spacer3.setPrefWidth(20);
    // Layout order: logo, search, spacer, profile
    navbar.getChildren().addAll(logoBox,spacer2,creativeZoneButton,recomendButton, spacer,searchBar,spacer3, profileStack);

    navbar.setEffect(new DropShadow(30,Color.BLACK));

    return navbar;
}

}
