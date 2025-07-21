package com.bytesquad.view_pages.CreativeZone;

import java.util.Stack;

import com.bytesquad.view_pages.ExplorePage.NaveBar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class CreativePageMain extends Application {


    private static final Stack<Node> contentHistory = new Stack<>();

    public static VBox content = new VBox();

    @Override
    public void start(Stage stage) throws Exception {

        // === Navbar ===
        HBox navebar = NaveBar.createNavbar();
        navebar.setPrefHeight(60);
        navebar.setPadding(new Insets(10, 20, 10, 20));
        navebar.setStyle("-fx-background-color: #f8f8f8;");
        navebar.setAlignment(Pos.CENTER_LEFT);

        // === Sidebar ===
        VBox sidebar = new VBox(20);
        sidebar.setPadding(new Insets(30));
        sidebar.setPrefWidth(300);
        sidebar.setStyle("-fx-background-color: linear-gradient(to bottom, #9D4EDD, #00B4D8); -fx-background-radius: 15;");
        sidebar.setAlignment(Pos.TOP_CENTER);

        Button userDashBoardbutton = createSidebarButton("My Dashboard");
        userDashBoardbutton.setMaxWidth(200);
        userDashBoardbutton.setOnAction(e ->{
            saveCurrentContentState(); 
            content.getChildren().clear();
            content.getChildren().addAll(UserDashBoard.getDashboardHeaderUI(content));
        });


        Button ongoingbutton = createSidebarButton("Discover Projects");
        ongoingbutton.setMaxWidth(200);
        ongoingbutton.setOnAction(e -> {
            saveCurrentContentState();
            content.getChildren().clear();
            content.getChildren().addAll(DiscoverProjects.createDiscoverProjects());
        });


        Button newIdeabutton = createSidebarButton("New Idea");
        newIdeabutton.setMaxWidth(200);
        newIdeabutton.setOnAction(e -> {
            saveCurrentContentState();
            content.getChildren().clear();
            content.getChildren().addAll(new NewIdeaForm().createNewIdeaForm());
        });

        // Button teambutton = createSidebarButton("Teams");
        // teambutton.setMaxWidth(200);

        Region spacer = new Region();
        spacer.setPrefHeight(350);

        Button logoutbutton = createSidebarButton("<- logout");
        logoutbutton.setOnMouseEntered(e -> logoutbutton.setStyle(
                "-fx-background-color: rgba(255, 0, 0, 0.7); " +
                "-fx-text-fill: black; " +
                "-fx-font-weight: bold; " +
                "-fx-background-radius: 12; " +
                "-fx-cursor: hand; " +
                "-fx-padding: 10 15 10 15;"
        ));


        sidebar.getChildren().addAll(userDashBoardbutton, ongoingbutton,newIdeabutton,  spacer ,logoutbutton);


                // ===== Back Button =====
        Button back = new Button("← Back");
        back.setOnAction(e -> {
            if (!contentHistory.isEmpty()) {
                VBox previousContent = (VBox) contentHistory.pop();
                content.getChildren().setAll(previousContent.getChildren());
            }
        });

        
        back.setStyle(
            "-fx-background-color: linear-gradient(to right, #f700ffff, #078bffff);" +  
            "-fx-text-fill: #333333;" +                                             
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 15;" +                                          
            "-fx-padding: 8 16;" +                                                  
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0, 0, 2);"
        );

        // Hover effect using pseudoclass
        back.setOnMouseEntered(e -> back.setStyle(
            "-fx-background-color: linear-gradient(to right, #309effff, #4800ffff);" +
            "-fx-text-fill: #000000;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 15;" +
            "-fx-padding: 8 16;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 6, 0, 0, 3);"
        ));

        back.setOnMouseExited(e -> back.setStyle(
            "-fx-background-color: linear-gradient(to right, #0724ffff, #ff00bbff);" +
            "-fx-text-fill: #333333;" +
            "-fx-font-size: 14px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 15;" +
            "-fx-padding: 8 16;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 4, 0, 0, 2);"
        ));




                // === Content Section ===


        content = new VBox();
        content.getChildren().add(UserDashBoard.getDashboardHeaderUI(content));




        ScrollPane contentScrollPane = new ScrollPane(content);
        contentScrollPane.setFitToWidth(true);
        contentScrollPane.setPadding(new Insets(20));
        contentScrollPane.setStyle("-fx-background-color: transparent;");
        contentScrollPane.setPrefViewportWidth(880); // 1100 - 180 sidebar - margins

        VBox backButtonandContent = new VBox(10,back,contentScrollPane);

        // === Body Layout ===
        HBox body = new HBox(20, sidebar, backButtonandContent);
        body.setPadding(new Insets(20));
        body.setPrefHeight(640);
        HBox.setHgrow(contentScrollPane, Priority.ALWAYS);

        // === Root Layout ===
        VBox root = new VBox(navebar, body);
        VBox.setVgrow(body, Priority.ALWAYS);

        // === Scene Setup ===
        Scene scene = new Scene(root, 1100, 700);
        stage.setScene(scene);
        stage.setTitle("Creative Zone Dashboard");
        stage.show();
    }



    private Button createSidebarButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(140);
        button.setStyle(
                "-fx-background-color: rgba(255,255,255,0.3); " +
                "-fx-text-fill: white; " +
                "-fx-font-weight: bold; " +
                "-fx-background-radius: 12; " +
                "-fx-cursor: hand; " +
                "-fx-padding: 10 15 10 15;"
        );

        // Hover effect
        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: rgba(255,255,255,0.5); " +
                "-fx-text-fill: black; " +
                "-fx-font-weight: bold; " +
                "-fx-background-radius: 12; " +
                "-fx-cursor: hand; " +
                "-fx-padding: 10 15 10 15;"
        ));
        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: rgba(255,255,255,0.3); " +
                "-fx-text-fill: white; " +
                "-fx-font-weight: bold; " +
                "-fx-background-radius: 12; " +
                "-fx-cursor: hand; " +
                "-fx-padding: 10 15 10 15;"
        ));
        return button;
    }
    
    public static void saveCurrentContentState() {
    if (!content.getChildren().isEmpty()) {
        VBox snapshot = new VBox();
        snapshot.getChildren().addAll(content.getChildren());
        contentHistory.push(snapshot);
    }
}


}


