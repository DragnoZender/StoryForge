package com.bytesquad.view_pages.CreativeZone;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class ProjectWorkSpace {

    public static VBox bodyBox = new VBox();



    public static HBox createHeaderWithPublishButton(){

        HBox headerWithPublishButton = new HBox(20);

        // Header Section
        HBox header = new HBox();
        header.setPadding(new Insets(20, 30, 20, 30));
        header.setSpacing(40);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: white; -fx-background-radius: 12; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 4);");

        // Title + Subtitle
        VBox titleBox = new VBox(5);
        Label titleLabel = new Label("Whispers in the Code");
        titleLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 22));
        Label subtitleLabel = new Label("Collaborative Workspace");
        subtitleLabel.setFont(Font.font("Segoe UI", 14));
        subtitleLabel.setTextFill(Color.web("#666"));

        titleBox.getChildren().addAll(titleLabel, subtitleLabel);

        // Modern Publish Button
        Button publishButton = new Button("Publish");
        publishButton.setStyle("""
            -fx-background-color: linear-gradient(to right, #8A2BE2, #7B68EE);
            -fx-text-fill: white;
            -fx-font-size: 14;
            -fx-font-weight: bold;
            -fx-background-radius: 8;
            -fx-padding: 8 18;
        """);

        Region spacer = new Region();
        spacer.setPrefWidth(250);

        headerWithPublishButton.getChildren().addAll(titleBox, spacer, publishButton);


        return headerWithPublishButton;
    }



    public static VBox createProjectWorkSpace() {

        HBox headerWithPublishButton = createHeaderWithPublishButton();


        // Button Box: overview , Chatroom & Files
        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.setPadding(new Insets(0, 30, 0, 30));

        Button overViewButton = new Button("💼 Project Overview");
        Button chatButton = new Button("💬 Chatroom");
        Button filesButton = new Button("📁 Files");

        String modernButtonStyle = """
            -fx-background-color: linear-gradient(to right, #f0f0f0, #e0e0e0);
            -fx-border-color: #ccc;
            -fx-text-fill: #333;
            -fx-font-size: 13;
            -fx-font-weight: 600;
            -fx-background-radius: 8;
            -fx-border-radius: 8;
            -fx-padding: 7 16;
        """;

        chatButton.setStyle(modernButtonStyle);

        chatButton.setOnAction(e -> {
            bodyBox.getChildren().clear();
            VBox chatroomWindow = createChatRoomView();
            ProjectWorkSpace.bodyBox.getChildren().addAll(chatroomWindow.getChildren());
        });

        filesButton.setStyle(modernButtonStyle);
        filesButton.setOnAction(e -> {
            bodyBox.getChildren().clear();
            bodyBox.getChildren().addAll(fileUploadWindow().getChildren());
        });


        overViewButton.setStyle(modernButtonStyle);
        overViewButton.setOnAction(e -> {
            bodyBox.getChildren().clear();
            bodyBox.getChildren().addAll(new ProjectDetailsView().createProjectDetailsView(
            "Time Rift",
            "A thrilling adventure where characters travel through wormholes to correct historical mistakes. Rich in sci-fi elements and strong emotional arcs.",
            "Sci-Fi",
            "time travel, adventure, dystopia",
            List.of("Writer", "Illustrator", "Editor")
        ).getChildren());
        });

        buttonBox.getChildren().addAll(overViewButton,chatButton, filesButton);


        bodyBox.getChildren().addAll(new ProjectDetailsView().createProjectDetailsView(
            "Time Rift",
            "A thrilling adventure where characters travel through wormholes to correct historical mistakes. Rich in sci-fi elements and strong emotional arcs.",
            "Sci-Fi",
            "time travel, adventure, dystopia",
            List.of("Writer", "Illustrator", "Editor")
        ).getChildren());

        ScrollPane projectDetailsScrollPane = new ScrollPane(bodyBox);
        projectDetailsScrollPane.setFitToWidth(true);

        Region spacer = new Region();
        spacer.setPrefHeight(30);
        
        Region spacer2 = new Region();
        spacer2.setPrefHeight(30);

        VBox root = new VBox(10,headerWithPublishButton,spacer,buttonBox,spacer2, bodyBox);
           // Gradient background for root VBox
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.setStyle("""
            -fx-background-color: linear-gradient(to bottom right, #FDFBFB, #EBEDEE);
        """);


        return root;
    }





    public static VBox createChatRoomView() {

        // Gradient background for root VBox
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.setStyle("""
            -fx-background-color: linear-gradient(to bottom right, #FDFBFB, #EBEDEE);
        """);
    

        VBox chatRoot = new VBox(10);
        chatRoot.setPadding(new Insets(20));
        chatRoot.setStyle("""
            -fx-background-color: linear-gradient(to bottom, #F5F7FA, #E4E9F0);
            -fx-background-radius: 12;
        """);

        // Header
        Label headerLabel = new Label("Team Chatroom");
        headerLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 20));
        headerLabel.setTextFill(Color.web("#333"));

        HBox header = new HBox(headerLabel);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(0, 0, 10, 0));

        // Scrollable chat area
        VBox messageBox = new VBox(10);
        messageBox.setPadding(new Insets(10));
        messageBox.setStyle("-fx-background-color: white; -fx-background-radius: 8;");
        messageBox.setPrefHeight(400);

        // Sample chat messages (static for now)
        Label msg1 = new Label("Alice: Hey everyone!");
        Label msg2 = new Label("Bob: Let's finalize the plot today.");
        msg1.setFont(Font.font("Segoe UI", 13));
        msg2.setFont(Font.font("Segoe UI", 13));

        messageBox.getChildren().addAll(msg1, msg2);

        ScrollPane scrollPane = new ScrollPane(messageBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-border-color: transparent;");

        // Message input area
        HBox inputArea = new HBox(10);
        inputArea.setAlignment(Pos.CENTER_LEFT);

        TextField messageInput = new TextField();
        messageInput.setPromptText("Type your message...");
        messageInput.setPrefWidth(500);
        messageInput.setStyle("""
            -fx-background-radius: 8;
            -fx-border-radius: 8;
            -fx-padding: 8;
            -fx-font-size: 13;
        """);

        Button sendButton = new Button("Send");
        sendButton.setStyle("""
            -fx-background-color: linear-gradient(to right, #4A90E2, #007AFF);
            -fx-text-fill: white;
            -fx-font-weight: bold;
            -fx-background-radius: 8;
            -fx-padding: 8 16;
        """);

        inputArea.getChildren().addAll(messageInput, sendButton);

        chatRoot.getChildren().addAll(header, scrollPane, inputArea);
        
        root.getChildren().addAll(chatRoot);

        return root;
    }

    public static VBox fileUploadWindow(){

        VBox root = new VBox();

        Button uploadfileButton = new Button("Upload file");
        root.getChildren().addAll(uploadfileButton);
        root.setAlignment(Pos.CENTER);
        return root;
    }
}
