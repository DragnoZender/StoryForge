package com.bytesquad.view_pages.CreativeZone;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DiscoverProjects {
    
    public static VBox createDiscoverProjects(){

        
// Title
Label title = new Label("Discover Creative Projects");
title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 26));
title.setTextFill(Color.web("#ffffff"));

// Subtitle
Label subtitle = new Label("Find exciting projects looking for collaborators and contribute your unique skills to amazing stories");
subtitle.setFont(Font.font("Segoe UI", 14));
subtitle.setTextFill(Color.web("#E0E0E0"));
subtitle.setWrapText(true);
subtitle.setMaxWidth(600);
subtitle.setAlignment(Pos.CENTER);

// Search Field
TextField searchField = new TextField();
searchField.setPromptText("Search projects...");
searchField.setPrefWidth(220);
searchField.setStyle("""
    -fx-font-size: 14;
    -fx-background-radius: 10;
    -fx-background-color: #ffffff;
    -fx-border-color: transparent;
    -fx-padding: 6 12 6 12;
""");

// Genre ComboBox
ComboBox<String> genreComboBox = new ComboBox<>();
genreComboBox.getItems().addAll("All Genres", "Fantasy", "Sci-Fi", "Mystery", "Romance");
genreComboBox.setValue("All Genres");
genreComboBox.setStyle("""
    -fx-font-size: 14;
    -fx-background-radius: 10;
    -fx-background-color: #ffffff;
    -fx-padding: 6 12 6 12;
""");

// Role ComboBox
ComboBox<String> roleComboBox = new ComboBox<>();
roleComboBox.getItems().addAll("All Roles", "Writer", "Illustrator", "Editor", "Composer");
roleComboBox.setValue("All Roles");
roleComboBox.setStyle("""
    -fx-font-size: 14;
    -fx-background-radius: 10;
    -fx-background-color: #ffffff;
    -fx-padding: 6 12 6 12;
""");

// Filters HBox
HBox searchFiltersBox = new HBox(12, searchField, genreComboBox, roleComboBox);
searchFiltersBox.setAlignment(Pos.CENTER);
searchFiltersBox.setPadding(new Insets(20));
searchFiltersBox.setStyle("""
    -fx-background-color: rgba(255, 255, 255, 0.15);
    -fx-background-radius: 12;
""");

// Header VBox
VBox headroot = new VBox(15, title, subtitle, searchFiltersBox);
headroot.setAlignment(Pos.CENTER);
headroot.setPadding(new Insets(40, 30, 40, 30));
headroot.setStyle("""
    -fx-background-color: linear-gradient(to bottom right, #9D4EDD, #00B4D8);
    -fx-background-radius: 20;
""");

        //Projects cards
        
        HBox card1 = ProjectCard.createProjectCard();
        HBox card2 = ProjectCard.createProjectCard();
        HBox card3 = ProjectCard.createProjectCard();
        HBox card4 = ProjectCard.createProjectCard();

        VBox bodyroot = new VBox(30,card1,card2,card3,card4);

        VBox root = new VBox(30,headroot,bodyroot);        

        return root;
    }
}
