package com.bytesquad.view_pages.CreativeZone;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ProjectCard {

    public static HBox createProjectCard() {
        // ---------- LEFT SECTION (Image or Placeholder) ----------
        ImageView projectImage;
        try {
            Image img = new Image("https://via.placeholder.com/140", 140, 140, false, false);
            projectImage = new ImageView(img);
            projectImage.setFitWidth(140);
            projectImage.setFitHeight(140);
            projectImage.setSmooth(true);
            projectImage.setStyle("-fx-background-radius: 12;");
        } catch (Exception e) {
            projectImage = new ImageView();
            projectImage.setFitWidth(140);
            projectImage.setFitHeight(140);
            projectImage.setStyle("-fx-background-color: #E0E0E0; -fx-background-radius: 12;");
        }

        // ---------- RIGHT SECTION ----------
        Label title = new Label("StoryForge");
        title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
        title.setTextFill(Color.web("#222"));

        Label description = new Label("A collaborative platform for writers, illustrators, and readers to create and enjoy stories together.");
        description.setWrapText(true);
        description.setFont(Font.font("Segoe UI", 13));
        description.setTextFill(Color.web("#666"));

        Label rolesNeeded = new Label("Looking for: Writer, Illustrator, Dialogue Writer");
        rolesNeeded.setFont(Font.font("Segoe UI", FontWeight.MEDIUM, 12));
        rolesNeeded.setTextFill(Color.web("#5E35B1"));

        HBox progressLine = createProgressLine(2); // Current stage: 0-3

        Region spacer = new Region();
        spacer.setPrefHeight(30);


        //Buttons
        Button viewDetailsButton = new Button("View Details");
        viewDetailsButton.setOnAction(e -> {
            CreativePageMain.saveCurrentContentState();
            VBox projectDetails = new ProjectDetailsView().createProjectDetailsView("Time Rift",
            "A thrilling adventure where characters travel through wormholes to correct historical mistakes. Rich in sci-fi elements and strong emotional arcs.",
            "Sci-Fi",
            "time travel, adventure, dystopia",
            List.of("Writer", "Illustrator", "Editor"));
            CreativePageMain.content.getChildren().clear();
            CreativePageMain.content.getChildren().addAll(projectDetails.getChildren());
        });


// Apply gradient background with rounded corners
viewDetailsButton.setStyle(
    "-fx-background-color: linear-gradient(to right, #3a7bd5, #8e44ad);" + // Blue to Purple
    "-fx-text-fill: white;" +                // White text
    "-fx-background-radius: 15;" +           // Rounded corners
    "-fx-padding: 8 20;" +                   // Padding for better look
    "-fx-font-weight: bold;" +               // Optional: Bold text
    "-fx-font-size: 14px;"                   // Optional: Font size
);

// Optional: Add drop shadow or cursor style on hover
viewDetailsButton.setOnMouseEntered(e ->
    viewDetailsButton.setStyle(
        "-fx-background-color: linear-gradient(to right, #3a7bd5, #8e44ad);" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 15;" +
        "-fx-padding: 8 20;" +
        "-fx-font-weight: bold;" +
        "-fx-font-size: 14px;" +
        "-fx-effect: dropshadow(one-pass-box, rgba(0,0,0,0.2), 5, 0.0, 0, 2);"
    )
);
viewDetailsButton.setOnMouseExited(e ->
    viewDetailsButton.setStyle(
        "-fx-background-color: linear-gradient(to right, #3a7bd5, #8e44ad);" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 15;" +
        "-fx-padding: 8 20;" +
        "-fx-font-weight: bold;" +
        "-fx-font-size: 14px;"
    )
);


Button requestJoinButton = new Button("Request Join");

// Apply gradient background with rounded corners
requestJoinButton.setStyle(
    "-fx-background-color: linear-gradient(to right, #3a7bd5, #8e44ad);" + // Blue to Purple
    "-fx-text-fill: white;" +                // White text
    "-fx-background-radius: 15;" +           // Rounded corners
    "-fx-padding: 8 20;" +                   // Padding for better look
    "-fx-font-weight: bold;" +               // Optional: Bold text
    "-fx-font-size: 14px;"                   // Optional: Font size
);

// Optional: Add drop shadow or cursor style on hover
requestJoinButton.setOnMouseEntered(e ->
    requestJoinButton.setStyle(
        "-fx-background-color: linear-gradient(to right, #3a7bd5, #8e44ad);" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 15;" +
        "-fx-padding: 8 20;" +
        "-fx-font-weight: bold;" +
        "-fx-font-size: 14px;" +
        "-fx-effect: dropshadow(one-pass-box, rgba(0,0,0,0.2), 5, 0.0, 0, 2);"
    )
);
requestJoinButton.setOnMouseExited(e ->
    requestJoinButton.setStyle(
        "-fx-background-color: linear-gradient(to right, #3a7bd5, #8e44ad);" +
        "-fx-text-fill: white;" +
        "-fx-background-radius: 15;" +
        "-fx-padding: 8 20;" +
        "-fx-font-weight: bold;" +
        "-fx-font-size: 14px;"
    )
);

        HBox buttonBox = new HBox(20,viewDetailsButton,requestJoinButton);
        

        VBox rightSection = new VBox(6, title, description, rolesNeeded, progressLine,spacer,buttonBox);
        rightSection.setPadding(new Insets(5, 0, 5, 10));
        rightSection.setAlignment(Pos.TOP_LEFT);

        // ---------- MAIN CARD ----------
        HBox card = new HBox(15, projectImage, rightSection);
        card.setPadding(new Insets(15));
        card.setStyle("""
            -fx-background-color: #FAFAFA;
            -fx-background-radius: 16;
            -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 8, 0.2, 0, 4);
        """ +
         "-fx-border-color: #8e44ad;" +       // Border color (purple)
    "-fx-border-width: 2;" +             // Border width (2px)
    "-fx-border-radius: 10;" +           // Optional: Rounded corners
    "-fx-padding: 10;" );
        card.setAlignment(Pos.CENTER_LEFT);
        card.setMaxWidth(700);
        return card;
    }

    private static HBox createProgressLine(int currentStage) {
        String[] stages = { "Idea", "Forming", "Development", "Publish" };
        HBox progress = new HBox(8);
        progress.setAlignment(Pos.CENTER_LEFT);
        progress.setPadding(new Insets(10, 0, 0, 0));

        for (int i = 0; i < stages.length; i++) {
            VBox step = new VBox(3);
            step.setAlignment(Pos.CENTER);

            Circle dot = new Circle(6);
            dot.setFill(i <= currentStage ? Color.web("#5E35B1") : Color.LIGHTGRAY);

            Label label = new Label(stages[i]);
            label.setFont(Font.font("Segoe UI", 10));
            label.setTextFill(Color.GRAY);

            step.getChildren().addAll(dot, label);
            progress.getChildren().add(step);

            if (i < stages.length - 1) {
                Line line = new Line(0, 0, 30, 0);
                line.setStroke(i < currentStage ? Color.web("#5E35B1") : Color.LIGHTGRAY);
                line.setStrokeWidth(1.5);
                progress.getChildren().add(line);
            }
        }
        return progress;
    }

    
}
