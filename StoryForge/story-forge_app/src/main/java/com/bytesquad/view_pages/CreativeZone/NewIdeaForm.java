package com.bytesquad.view_pages.CreativeZone;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class NewIdeaForm {

    public VBox createNewIdeaForm() {
        VBox form = new VBox(18);
        form.setPadding(new Insets(30));
        form.setAlignment(Pos.TOP_CENTER);
        form.setStyle("""
            -fx-background-color: #FFFFFF;
            -fx-background-radius: 20;
            -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 15, 0, 0, 5);
        """);

        Font labelFont = Font.font("Segoe UI Semibold", 14);
        Font inputFont = Font.font("Segoe UI", 13);

        // Title
        Label titleLabel = new Label("Project Title");
        titleLabel.setFont(labelFont);
        TextField titleField = new TextField();
        titleField.setPromptText("Enter project title");
        styleInput(titleField, inputFont);

        // Description
        Label descLabel = new Label("Project Description");
        descLabel.setFont(labelFont);
        TextArea descArea = new TextArea();
        descArea.setPromptText("Describe your project idea...");
        descArea.setWrapText(true);
        descArea.setPrefRowCount(4);
        descArea.setFont(inputFont);
        descArea.setStyle("""
            -fx-background-radius: 10;
            -fx-border-color: #dcdcdc;
            -fx-border-radius: 10;
        """);

        // Genre
        Label genreLabel = new Label("Genre");
        genreLabel.setFont(labelFont);
        ComboBox<String> genreCombo = new ComboBox<>();
        genreCombo.getItems().addAll("Fantasy", "Sci-Fi", "Romance", "Thriller", "Comedy", "Action");
        genreCombo.setPromptText("Select genre");
        styleInput(genreCombo, inputFont);

        // Tags
        Label tagLabel = new Label("Tags");
        tagLabel.setFont(labelFont);
        TextField tagField = new TextField();
        tagField.setPromptText("e.g. magic, adventure, betrayal");
        styleInput(tagField, inputFont);

        // Roles
        Label rolesLabel = new Label("Roles Needed");
        rolesLabel.setFont(labelFont);
        CheckBox writer = new CheckBox("Writer");
        CheckBox illustrator = new CheckBox("Illustrator");
        CheckBox editor = new CheckBox("Editor");
        CheckBox comicArtist = new CheckBox("Comic Artist");

        for (CheckBox cb : new CheckBox[]{writer, illustrator, editor, comicArtist}) {
            cb.setFont(inputFont);
        }

        VBox rolesBox = new VBox(8, writer, illustrator, editor, comicArtist);
        rolesBox.setPadding(new Insets(8, 0, 8, 12));

        // Submit Button
        Button submitBtn = new Button("🚀 Submit Idea");
        submitBtn.setFont(Font.font("Segoe UI Semibold", 14));
        submitBtn.setStyle("""
            -fx-background-color: linear-gradient(to right, #48F8C0, #53D2DC);
            -fx-text-fill: black;
            -fx-font-weight: bold;
            -fx-background-radius: 30;
            -fx-padding: 10 24;
            -fx-cursor: hand;
        """);

        submitBtn.setOnMouseEntered(e -> submitBtn.setStyle("""
            -fx-background-color: linear-gradient(to right, #53D2DC, #48F8C0);
            -fx-text-fill: black;
            -fx-font-weight: bold;
            -fx-background-radius: 30;
            -fx-padding: 10 24;
            -fx-cursor: hand;
        """));

        submitBtn.setOnMouseExited(e -> submitBtn.setStyle("""
            -fx-background-color: linear-gradient(to right, #48F8C0, #53D2DC);
            -fx-text-fill: black;
            -fx-font-weight: bold;
            -fx-background-radius: 30;
            -fx-padding: 10 24;
            -fx-cursor: hand;
        """));

        // Add all to form
        form.getChildren().addAll(
                titleLabel, titleField,
                descLabel, descArea,
                genreLabel, genreCombo,
                tagLabel, tagField,
                rolesLabel, rolesBox,
                submitBtn
        );

        return form;
    }

    private void styleInput(Control control, Font font) {
        if (control instanceof TextField textField) {
            textField.setFont(font);
        } else if (control instanceof ComboBox<?> comboBox) {
            comboBox.setStyle("-fx-font-size: 13;");
        }
        control.setStyle("""
            -fx-background-radius: 10;
            -fx-border-color: #dcdcdc;
            -fx-border-radius: 10;
        """);
        control.setPrefWidth(300);
    }
}
