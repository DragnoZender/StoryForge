package com.bytesquad.view_pages.CreativeZone;


import javafx.util.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyProjectCard {

    public static VBox createCardVBox(VBox mainContent) {
    // Main VBox (the card)
    VBox cardBox = new VBox(12);
    cardBox.setPadding(new Insets(18));
    cardBox.setStyle(
        "-fx-background-color: #fafbfc;" +
        "-fx-border-radius: 12;" +
        "-fx-background-radius: 12;" +
        "-fx-border-color: #e2e6ea;" +
        "-fx-border-width: 1;"
    );

    // Title and Status
    HBox titleStatusBox = new HBox(8);
    Label title = new Label("Whispers in the Code");
    title.setFont(Font.font(17));
    Label status = new Label("in progress");
    status.setStyle(
        "-fx-background-color: #e4f1fe; " +
        "-fx-text-fill: #3578e5; " +
        "-fx-font-size: 11; " +
        "-fx-background-radius: 10;"
    );
    status.setPadding(new Insets(2, 10, 2, 10));
    titleStatusBox.getChildren().addAll(title, status);
    titleStatusBox.setAlignment(Pos.CENTER_LEFT);

    // Description
    Label description = new Label("A cyberpunk thriller about a hacker who discovers...");
    description.setWrapText(true);
    description.setStyle("-fx-text-fill: #2c3e50; -fx-font-size: 13;");

    // Tags
    HBox tagsBox = new HBox(7);
    Label tag1 = new Label("Cyberpunk");
    tag1.setStyle("-fx-background-color: #edf7fa; -fx-text-fill: #26adc6; -fx-background-radius: 6; -fx-padding: 3 8 3 8;");
    Label tag2 = new Label("Thriller");
    tag2.setStyle("-fx-background-color: #f1e6fe; -fx-text-fill: #a155e6; -fx-background-radius: 6; -fx-padding: 3 8 3 8;");
    Label tag3 = new Label("Technology");
    tag3.setStyle("-fx-background-color: #f0e3fa; -fx-text-fill: #b86dfa; -fx-background-radius: 6; -fx-padding: 3 8 3 8;");
    tagsBox.getChildren().addAll(tag1, tag2, tag3);

    // Users and Date
    HBox infoBox = new HBox(10);

    // Placeholder avatars (add images as desired)
    ImageView avatar1 = new ImageView(); // avatar1.setImage(new Image("path_to_avatar1.png"));
    avatar1.setFitHeight(26);
    avatar1.setFitWidth(26);
    avatar1.setStyle("-fx-background-radius: 13;");

    ImageView avatar2 = new ImageView(); // avatar2.setImage(new Image("path_to_avatar2.png"));
    avatar2.setFitHeight(26);
    avatar2.setFitWidth(26);
    avatar2.setStyle("-fx-background-radius: 13;");

    HBox avatarsBox = new HBox(-7, avatar1, avatar2);

    Label dateLabel = new Label("Jan 10, 2025");
    dateLabel.setStyle("-fx-text-fill: #888; -fx-font-size: 12;");
    infoBox.getChildren().addAll(avatarsBox, dateLabel);
    infoBox.setAlignment(Pos.CENTER_LEFT);

    // Open Workspace Button
    Button openBtn = new Button("Open Workspace");
    openBtn.setStyle(
        "-fx-background-color: #a156f6; " +
        "-fx-text-fill: white; " +
        "-fx-font-size: 14; " +
        "-fx-background-radius: 7;"
    );
    openBtn.setMaxWidth(Double.MAX_VALUE);

        openBtn.setOnAction(e -> {
            CreativePageMain.saveCurrentContentState();
            VBox workspace = ProjectWorkSpace.createProjectWorkSpace();
            CreativePageMain.content.getChildren().clear();
            CreativePageMain.content.getChildren().addAll(workspace.getChildren());
        });

    // Assemble the card
    cardBox.getChildren().addAll(
        titleStatusBox,
        description,
        tagsBox,
        infoBox,
        openBtn
    );

    applyElevationEffect(cardBox);

    return cardBox;
}
 
    public static void applyElevationEffect(Region card) {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(0);
        shadow.setOffsetY(0);
        shadow.setColor(Color.rgb(0, 0, 0, 0.2));

        card.setEffect(shadow);

        // On Hover
        card.setOnMouseEntered((MouseEvent e) -> {
            Timeline enterAnimation = new Timeline(
                new KeyFrame(Duration.millis(200),
                    new KeyValue(shadow.radiusProperty(), 20),
                    new KeyValue(shadow.offsetYProperty(), 10),
                    new KeyValue(shadow.colorProperty(), Color.rgb(0, 0, 0, 0.3)) 
                )
            );
            enterAnimation.play();
        });

        // On Exit
        card.setOnMouseExited((MouseEvent e) -> {
            Timeline exitAnimation = new Timeline(
                new KeyFrame(Duration.millis(200),
                    new KeyValue(shadow.radiusProperty(), 0),
                    new KeyValue(shadow.offsetYProperty(), 0),
                    new KeyValue(shadow.colorProperty(), Color.rgb(0, 0, 0, 0.2)) // reset to soft
                )
            );
            exitAnimation.play();
        });
    }
}
