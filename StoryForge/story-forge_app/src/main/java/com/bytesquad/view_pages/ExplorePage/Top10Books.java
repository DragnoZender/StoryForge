package com.bytesquad.view_pages.ExplorePage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Top10Books {
    
        BookCard bookCard = new BookCard();
    

        public VBox createTop10Section() {


        
    Stop[] backgroundGradient = new Stop[] {
        new Stop(0, Color.web("#0095ffff")),  // very light gray instead of strong gradient
        new Stop(1, Color.web("#00ff48ff"))
    };
    Background background = new Background(new BackgroundFill(
        new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, backgroundGradient),
        new CornerRadii(12), new Insets(20)
    ));

Label heading = new Label("Top 10 of all Time");
heading.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
heading.setTextFill(Color.web("#02664E"));  // deep teal color matching your theme
heading.setPadding(new Insets(10, 0, 10, 0));

// Add an underline effect using a bottom border via CSS style
heading.setStyle(
    "-fx-border-color: transparent transparent #02664E transparent; " +  // only bottom border
    "-fx-border-width: 0 0 3 0; " +                                     // thick bottom border
    "-fx-border-style: solid;"
);


    // Create book cards as before
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

                VBox card9 = bookCard.createBookCard(
                "Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}
        );
                VBox card10 = bookCard.createBookCard(
                "Sci-Fi", "The Last Starkeeper", "In a universe where stars are dying one by one...",
                "file:assets/book1.jpg", "Alex Johnson", "file:assets/author1.jpg",
                "4.8", "15.4K", new String[]{"space", "adventure", "young adult"}
        );

    // Create HBoxes for top 5 and next 5
    HBox oneToFive = new HBox(40, card1, card2, card3, card4, card5);

    HBox sixToTen = new HBox(40, card6, card7, card8, card9, card10);

    // Center cards horizontally in their containers
    oneToFive.setAlignment(Pos.CENTER);
    sixToTen.setAlignment(Pos.CENTER);

    // Create main VBox container for these two rows
    VBox cardsContainer = new VBox(20, oneToFive, sixToTen);
    cardsContainer.setAlignment(Pos.CENTER);
    cardsContainer.setMaxWidth(300);

    // Style cardsContainer as a big square card
    cardsContainer.setPrefWidth(1100);  // width to fit all cards in a neat row
    cardsContainer.setPadding(new Insets(25));
    cardsContainer.setBackground(background);
    cardsContainer.setStyle("-fx-border-radius: 12; -fx-background-radius: 12; " +
                            "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 12, 0, 0, 4);");

    // Wrap in another VBox to center on main page
    VBox mainWrapper = new VBox(heading,cardsContainer);
    mainWrapper.setAlignment(Pos.CENTER);
    mainWrapper.setPadding(new Insets(40)); // outer padding to separate from edges
    mainWrapper.setBackground(background);
    


    return mainWrapper;
}

}
