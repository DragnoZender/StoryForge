package com.bytesquad.view_pages.ExplorePage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExploreMainPage extends Application{

    @Override
    public void start(Stage arg0) throws Exception {

        // Navebar
        HBox naveBar = NaveBar.createNavbar();

        // New relsease section
        ScrollPane newRelease = new NewRelease().createBookScrollPane();

        //top10 section
        VBox top10Section = new Top10Books().createTop10Section();

        VBox bycatergorySection = new ByCategory().createCategorySection();


        BorderPane  root = new BorderPane();
        root.setTop(naveBar);

        VBox content = new VBox(40);
        content.getChildren().addAll(
            newRelease,
            top10Section,
            bycatergorySection
        );
        content.setPadding(new Insets(20,20,20,20));

        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);  // vertical only
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        root.setCenter(scrollPane);

        Scene sc = new Scene(root,1000,800);
        arg0.setScene(sc);
        arg0.show();

    }
    
}
