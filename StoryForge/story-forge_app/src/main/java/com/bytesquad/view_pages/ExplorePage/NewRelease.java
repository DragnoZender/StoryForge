package com.bytesquad.view_pages.ExplorePage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class NewRelease {

    BookCard bookCard = new BookCard();

public ScrollPane createBookScrollPane() {
    HBox cardContainer = new HBox(20);
    cardContainer.setPadding(new Insets(20));
    cardContainer.setAlignment(Pos.TOP_LEFT);

    // Add background gradient to card container
    Stop[] gradientStops = new Stop[] {
        new Stop(0, Color.web("#53D2DC")),  // light turquoise
        new Stop(1, Color.web("#02664E"))   // deep teal
    };
    LinearGradient bgGradient = new LinearGradient(
        0, 0, 1, 0, true, CycleMethod.NO_CYCLE, gradientStops
    );
    cardContainer.setBackground(new Background(new BackgroundFill(
        bgGradient,
        new CornerRadii(15),
        Insets.EMPTY
    )));

    // Add subtle drop shadow for depth
    DropShadow shadow = new DropShadow();
    shadow.setRadius(8);
    shadow.setOffsetX(0);
    shadow.setOffsetY(4);
    shadow.setColor(Color.color(0, 0, 0, 0.15));
    cardContainer.setEffect(shadow);

        // === Book Card 1 ===
        VBox card1 = bookCard.createBookCard(
                "Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}
        );

        // === Book Card 2 ===
        VBox card2 = bookCard.createBookCard(
                "Romance", "Moonlit Café", "A cozy romance about a night owl barista and a baker...",
                "file:assets/book2.jpg", "Emma Thompson", "file:assets/author2.jpg",
                "4.6", "23.4K", new String[]{"romance", "coffee", "contemporary"}
        );

        // === Book Card 3 ===
        VBox card3 = bookCard.createBookCard(
                "Mystery", "Shadow Detective", "A noir mystery following Sarah Cross...",
                "file:assets/book3.jpg", "Marcus Johnson", "file:assets/author3.jpg",
                "4.7", "18.9K", new String[]{"detective", "noir", "mystery"}
        );

        // === Book Card 4 ===
        VBox card4 = bookCard.createBookCard(
                "Fantasy", "Dragon's Heart", "An epic fantasy tale of a young dragon rider...",
                "file:assets/book4.jpg", "Luna Rodriguez", "file:assets/author4.jpg",
                "4.9", "31.2K", new String[]{"dragons", "fantasy", "adventure"}
        );


        VBox card5 = bookCard.createBookCard(
                "Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}
        );

        VBox card6 = bookCard.createBookCard(
                "Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}
        );

                VBox card7 = bookCard.createBookCard(
                "Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}
        );

        VBox card8 = bookCard.createBookCard(
                "Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}
        );

    cardContainer.getChildren().addAll(card1, card2, card3, card4, card5, card6, card7, card8);

    ScrollPane scrollPane = new ScrollPane(cardContainer);
    scrollPane.setFitToHeight(true);
    scrollPane.setFitToWidth(false);
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    // Make ScrollPane background transparent to show gradient behind
    scrollPane.setStyle("-fx-background-color: transparent; -fx-background-insets: 0;");

    // Optional: Customize scrollbar style (simple example)
    scrollPane.lookupAll(".scroll-bar").forEach(scrollBar -> {
        scrollBar.setStyle("-fx-background-color: transparent;");
    });

    return scrollPane;
}
}
