package com.bytesquad.view_pages.CreativeZone;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class ProjectDetailsView {

    public VBox createProjectDetailsView(String title, String description, String genre, String tags, List<String> rolesNeeded) {
        VBox detailsBox = new VBox(22);


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



        detailsBox.setPadding(new Insets(32));
        detailsBox.setAlignment(Pos.TOP_LEFT);
        detailsBox.setStyle("""
            -fx-background-color: linear-gradient(to bottom right, #ffffff 75%, #d9f6ee 100%);
            -fx-background-radius: 20;
            -fx-border-radius: 20;
            -fx-border-width: 1.5;
            -fx-border-color: #e2ecec;
            -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.12), 20, 0.18, 0, 10);
        """);

        Font headingFont = Font.font("Segoe UI Semibold", 16);
        Font contentFont = Font.font("Segoe UI", 13.5);

        // Title (styled like a card headline)
        Label titleLabel = new Label("📌 " + title);
        titleLabel.setFont(Font.font("Segoe UI Bold", 23));
        titleLabel.setTextFill(Color.web("#02664E"));
        titleLabel.setStyle("""
            -fx-background-color:linear-gradient(to right,#e5fdf5 85%,#bfe8fc) ;
            -fx-padding: 8 22 8 16;
            -fx-background-radius: 16;
        """);


        Region spacer = new Region();
        spacer.setPrefWidth(400);
        HBox titleLabelAndJoinButtonBox = new HBox(10,titleLabel,spacer,requestJoinButton);

        VBox descSection = createSection("📝 Description", description, headingFont, contentFont, false);
        VBox genreSection = createSection("🎭 Genre", genre, headingFont, contentFont, false);
        VBox tagSection = createTagSection("🏷️ Tags", tags, headingFont);

        // Roles Section with badge-style pills
        Label rolesHeader = new Label("👥 Roles Needed");
        rolesHeader.setFont(headingFont);
        VBox rolesBox = new VBox(8);
        for (String role : rolesNeeded) {
            Label roleLabel = new Label(role);
            roleLabel.setFont(contentFont);
            roleLabel.setStyle("""
                -fx-background-color: #def9ee;
                -fx-text-fill: #02735e;
                -fx-padding: 5 13 5 13;
                -fx-background-radius: 13;
                -fx-font-weight: bold;
            """);
            rolesBox.getChildren().add(roleLabel);
        }

        VBox rolesSection = new VBox(6, rolesHeader, rolesBox);
        rolesSection.setPadding(new Insets(3, 0, 0, 0));
        rolesSection.setStyle("-fx-background-radius: 13; -fx-padding: 9 12 9 12;");


        // Adding separators between sections for clarity
        detailsBox.getChildren().addAll(
                titleLabelAndJoinButtonBox, separatorLine(),
                descSection, separatorLine(),
                genreSection, separatorLine(),
                tagSection, separatorLine(),
                rolesSection , separatorLine()

        );
        return detailsBox;
    }

    private VBox createSection(String header, String content, Font headerFont, Font contentFont, boolean includeDivider) {
        Label headerLabel = new Label(header);
        headerLabel.setFont(headerFont);

        Label contentLabel = new Label(content);
        contentLabel.setFont(contentFont);
        contentLabel.setWrapText(true);
        contentLabel.setStyle("-fx-text-fill: #055158;");

        VBox section = new VBox(3,headerLabel, contentLabel);
        section.setPadding(new Insets(6, 0, 0, 0));
        section.setStyle("""
                -fx-background-radius: 13;
                -fx-padding: 8 12 8 12;
        """);
        return section;
    }

    // Render tags as pills
    private VBox createTagSection(String header, String tags, Font headerFont) {
        Label headerLabel = new Label(header);
        headerLabel.setFont(headerFont);

        FlowPane tagPane = new FlowPane(6, 6);
        tagPane.setPadding(new Insets(4, 0, 0, 0));
        if (tags != null && !tags.isEmpty()) {
            String[] tagArray = tags.split(",");
            for (String tag : tagArray) {
                Label tagLabel = new Label(tag.trim());
                tagLabel.setStyle("""
                        -fx-background-color: #e4f3fd;
                        -fx-text-fill: #3984ad;
                        -fx-padding: 4 13 4 13;
                        -fx-background-radius: 13;
                        -fx-font-weight: 500;
                """);
                tagPane.getChildren().add(tagLabel);
            }
        }
        VBox section = new VBox(3, headerLabel, tagPane);
        section.setStyle("-fx-padding: 8 0 0 0;");
        return section;
    }

    // Section divider line
    private Region separatorLine() {
        Line line = new Line(0, 0, 500, 0); // Width will be bound automatically
        line.setStroke(Color.web("#d5ede7"));
        line.setStrokeWidth(1.3);
        HBox lineBox = new HBox(line);
        lineBox.setAlignment(Pos.CENTER_LEFT);
        lineBox.setPadding(new Insets(8, 0, 8, 0));
        return lineBox;
    }
}
