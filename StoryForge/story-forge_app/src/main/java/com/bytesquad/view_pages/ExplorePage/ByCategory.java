package com.bytesquad.view_pages.ExplorePage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ByCategory {

    public VBox createCategorySection() {
        VBox categorySection = new VBox(15);
        categorySection.setPadding(new Insets(20));
        categorySection.setAlignment(Pos.TOP_CENTER); 
        // Heading label
        Label heading = new Label("Browse by Category");
        heading.setFont(Font.font("Segoe UI", FontWeight.BOLD, 22));
        heading.setTextFill(Color.web("#02664E"));
        heading.setPadding(new Insets(0, 0, 10, 0));
        heading.setStyle(
            "-fx-border-color: transparent transparent #02664E transparent; " +
            "-fx-border-width: 0 0 3 0; " +
            "-fx-border-style: solid;"
        );

        FlowPane categoriesPane = new FlowPane(); 
        categoriesPane.setVgap(20);
        categoriesPane.setAlignment(Pos.CENTER); 
        categoriesPane.setPadding(new Insets(10, 0, 0, 0));

    
        String[] categories = {
            "Science Fiction", "Romance", "Mystery", "Fantasy",
            "Non-fiction", "Thriller", "Historical", "Biography",
            "Adventure", "Horror", "Self-Help", 
        };

        for (String category : categories) {
            VBox card = createCategoryCard(category);
            categoriesPane.getChildren().add(card);
        }

        categorySection.getChildren().addAll(heading, categoriesPane);
        return categorySection;
    }

    private VBox createCategoryCard(String categoryName) {
        VBox card = new VBox(10);
        card.setPrefSize(140, 140);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(15));
        card.setCursor(Cursor.HAND);

        // Background color
        Color bgColor = switch (categoryName.toLowerCase()) {
            case "science fiction" -> Color.web("#A3CEF1");
            case "romance" -> Color.web("#F6C6EA");
            case "mystery" -> Color.web("#D3C0EB");
            case "fantasy" -> Color.web("#C1E1C1");
            case "non-fiction" -> Color.web("#FFD6A5");
            case "thriller" -> Color.web("#F9AFAE");
            case "historical" -> Color.web("#F4E2D8");
            case "biography" -> Color.web("#B5EAD7");
            case "adventure" -> Color.web("#FFDAC1");
            case "horror" -> Color.web("#FF9AA2");
            case "self-help" -> Color.web("#C7CEEA");
            case "young adult" -> Color.web("#E2F0CB");
            default -> Color.web("#E0E0E0");
        };

        card.setBackground(new Background(new BackgroundFill(bgColor, new CornerRadii(12), Insets.EMPTY)));

        Label label = new Label(categoryName);
        label.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 14));
        label.setTextFill(Color.web("#02664E"));
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);

        card.getChildren().addAll(label);

        // Hover effect
        card.setOnMouseEntered(e -> card.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.12), 10, 0, 0, 4);"));
        card.setOnMouseExited(e -> card.setEffect(null));

        return card;
    }
}
