package com.bytesquad.view_pages.CreativeZone;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class MyReadingBookCard {

        public static VBox createBookCard(String genre, String title, String description,
                                String coverUrl, String author, String authorImage,
                                String rating, String views, String[] tags) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(10));
        card.setPrefWidth(200);
        card.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 12; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.05), 8, 0, 0, 4);");

        // Genre label
        Label genreLabel = new Label(genre);
        genreLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 11));
        genreLabel.setTextFill(Color.web("#A52A2A"));
        genreLabel.setStyle("-fx-background-color: #FFEFEF; -fx-padding: 2 8 2 8; -fx-background-radius: 8;");

        // Book cover
        ImageView cover = new ImageView(new Image(coverUrl));
        cover.setFitHeight(100);
        cover.setFitWidth(180);
        cover.setSmooth(true);
        cover.setPreserveRatio(false);

        // Title
        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 14));
        titleLabel.setWrapText(true);

        // Description
        Label descLabel = new Label(description);
        descLabel.setFont(Font.font("Segoe UI", 11));
        descLabel.setTextFill(Color.GRAY);
        descLabel.setWrapText(true);

        // Rating & views
        Label ratingLabel = new Label("★ " + rating + "   👁 " + views);
        ratingLabel.setFont(Font.font("Segoe UI", 11));

        // Author info
        ImageView authorPic = new ImageView(new Image(authorImage));
        authorPic.setFitHeight(24);
        authorPic.setFitWidth(24);
        authorPic.setClip(new Circle(12, 12, 12));

        Label authorLabel = new Label(author + "\nAuthor");
        authorLabel.setFont(Font.font("Segoe UI", 10));

        HBox authorBox = new HBox(10, authorPic, authorLabel);
        authorBox.setAlignment(Pos.CENTER_LEFT);

        // Tags
        FlowPane tagPane = new FlowPane(5, 5);
        for (String tag : tags) {
            Label tagLabel = new Label(tag);
            tagLabel.setStyle("-fx-background-color: #F3F3F3; -fx-padding: 3 8 3 8; -fx-background-radius: 10;");
            tagLabel.setFont(Font.font("Segoe UI", 10));
            tagPane.getChildren().add(tagLabel);
        }

        // Buttons
        Button continueRead = new Button("📖 continue reading");
        Button removFromLibrary = new Button("Remove from Library");

        continueRead.setStyle("-fx-background-color: #A855F7; -fx-text-fill: white; -fx-background-radius: 10;");
        removFromLibrary.setStyle("-fx-border-color: #D6B4FF; -fx-text-fill: #7C3AED; -fx-background-radius: 10;");

        continueRead.setPrefWidth(135);
        removFromLibrary.setPrefWidth(85);

        HBox buttons = new HBox(10, continueRead);
        buttons.setAlignment(Pos.CENTER);

        DropShadow ds = new DropShadow(10, Color.BLACK);
        card.setEffect(ds);

        card.getChildren().addAll(genreLabel, cover, titleLabel, descLabel, ratingLabel, authorBox, tagPane, buttons);


        return card;
    }
    
}
