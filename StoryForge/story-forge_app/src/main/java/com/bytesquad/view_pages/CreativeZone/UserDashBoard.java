package com.bytesquad.view_pages.CreativeZone;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class UserDashBoard {

    
    public static VBox getDashboardHeaderUI(VBox mainPageContent) {
        VBox mainContainer = new VBox(20);
        mainContainer.setPadding(new Insets(20));
        mainContainer.setAlignment(Pos.CENTER_LEFT);

        // === Welcome Banner ===
        VBox welcomeBanner = new VBox(10);
        welcomeBanner.setPadding(new Insets(20));
        welcomeBanner.setAlignment(Pos.TOP_LEFT);
        welcomeBanner.setBackground(new Background(new BackgroundFill(
                new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#9D4EDD")),
                        new Stop(1, Color.web("#00B4D8"))),
                new CornerRadii(12), Insets.EMPTY
        )));

        Label welcomeText = new Label("Welcome back, Alex!");
        welcomeText.setTextFill(Color.WHITE);
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Label subText = new Label("Ready to bring your stories to life? Let's create something amazing together.");
        subText.setTextFill(Color.WHITE);
        subText.setFont(Font.font("Arial", 14));

        HBox statsBox = new HBox(20);
        statsBox.setAlignment(Pos.CENTER_LEFT);


        welcomeBanner.getChildren().addAll(welcomeText, subText, statsBox);

        // === Quick Action Cards ===
        HBox actionCardBox = new HBox(20);
        actionCardBox.setAlignment(Pos.CENTER);
        actionCardBox.setPadding(new Insets(10));


        Text myProjectsText = new Text("My Projects");
        myProjectsText.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        HBox myProjectsBox = new HBox(10,MyProjectCard.createCardVBox(mainPageContent),MyProjectCard.createCardVBox(mainPageContent),MyProjectCard.createCardVBox(mainPageContent),MyProjectCard.createCardVBox(mainPageContent),MyProjectCard.createCardVBox(mainPageContent),MyProjectCard.createCardVBox(mainPageContent),MyProjectCard.createCardVBox(mainPageContent),MyProjectCard.createCardVBox(mainPageContent),MyProjectCard.createCardVBox(mainPageContent));
        myProjectsBox.setStyle(
        "-fx-border-color: #ffffffff;" +     // Blue border
        "-fx-border-width: 2px;" +         // Border thickness
        "-fx-border-radius: 10;" +         // Rounded corners (optional)
        "-fx-padding: 10;"                 // Padding inside the border
    );



        ScrollPane myProjectScrollPane = new ScrollPane(myProjectsBox);
        myProjectScrollPane.setPrefHeight(238);
        myProjectScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Remove horizontal scrollbar
        myProjectScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Remove vertical scrollbar
        myProjectScrollPane.setStyle(
            "-fx-border-color: #ccccccff;" +     // Blue border
            "-fx-border-width: 2px;" +         // Border thickness
            "-fx-border-radius: 8;" +          // Optional rounded corners
            "-fx-background-color: white;"     // Optional background
        );

        Text myReadingText = new Text("My Readings");
        myReadingText.setFont(Font.font("Arial", FontWeight.BOLD, 22));

        HBox myReadingsBox = new HBox(10,MyReadingBookCard.createBookCard("Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}),
                MyReadingBookCard.createBookCard("Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}),
                MyReadingBookCard.createBookCard("Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}),
                MyReadingBookCard.createBookCard("Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"})
                
                );
        myProjectsBox.setStyle(
        "-fx-border-color: #ffffffff;" +     // Blue border
        "-fx-border-width: 2px;" +         // Border thickness
        "-fx-border-radius: 10;" +         // Rounded corners (optional)
        "-fx-padding: 10;"                 // Padding inside the border
    );

        VBox myProjectsVBox = new VBox(10,myProjectsText,myProjectScrollPane);
        ScrollPane myReadingsScrollPane = new ScrollPane(myReadingsBox);
        myReadingsScrollPane.setPrefHeight(338);
        myReadingsScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Remove horizontal scrollbar
        myReadingsScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Remove vertical scrollbar
        myReadingsScrollPane.setStyle(
            "-fx-border-color: #ccccccff;" +     // Blue border
            "-fx-border-width: 2px;" +         // Border thickness
            "-fx-border-radius: 8;" +          // Optional rounded corners
            "-fx-background-color: white;"     // Optional background
        );

        Region spacer = new Region();
        spacer.setPrefHeight(15);
        Region spacer2 = new Region();
        spacer2.setPrefHeight(15);


        mainContainer.getChildren().addAll(welcomeBanner,spacer2,myProjectsText,myProjectsVBox,spacer,myReadingText,myReadingsScrollPane);
        return mainContainer;
    }



}
