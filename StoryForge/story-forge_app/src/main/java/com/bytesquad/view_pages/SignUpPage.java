package com.bytesquad.view_pages;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class SignUpPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #47D6D0, #7EE8D8);");

        VBox formContainer = new VBox(15);
        formContainer.setPadding(new Insets(30));
        formContainer.setMaxWidth(400);
        formContainer.setStyle("-fx-background-color: white; -fx-background-radius: 15; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 10, 0, 0, 5);");

        // Title
        Text title = new Text("StoryForge");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setFill(Color.web("#008080"));
        title.setTextAlignment(TextAlignment.CENTER);

        Text subtitle = new Text("Join StoryForge");
        subtitle.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 18));
        subtitle.setTextAlignment(TextAlignment.CENTER);

        Text tagline = new Text("Start your storytelling journey today.");
        tagline.setFont(Font.font("Arial", FontPosture.REGULAR, 12));
        tagline.setFill(Color.GRAY);
        tagline.setTextAlignment(TextAlignment.CENTER);

        VBox headingBox = new VBox(2, title, subtitle, tagline);
        headingBox.setAlignment(Pos.CENTER);

        // Input Fields
        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Enter your full name");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email address");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Choose a unique username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Create a strong password");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm your password");

        // Terms and Conditions
        CheckBox agreeBox = new CheckBox("I agree to the ");
        Hyperlink termsLink = new Hyperlink("Terms of Service");
        Hyperlink privacyLink = new Hyperlink("Privacy Policy");

        HBox termsBox = new HBox(5, agreeBox, termsLink, new Label("and"), privacyLink);
        termsBox.setAlignment(Pos.CENTER_LEFT);

        // Submit Button
        Button createBtn = new Button("Create Your StoryForge Account");
        createBtn.setMaxWidth(Double.MAX_VALUE);
        createBtn.setStyle("-fx-background-color: #FFE3B3; -fx-font-weight: bold;");

        // Login Prompt
        Hyperlink loginLink = new Hyperlink("Log In");
        Text already = new Text("Already have an account? ");
        HBox loginBox = new HBox(5, already, loginLink);
        loginBox.setAlignment(Pos.CENTER);

        // Assemble form
        formContainer.getChildren().addAll(
                headingBox,
                fullNameField,
                emailField,
                usernameField,
                passwordField,
                confirmPasswordField,
                termsBox,
                createBtn,
                loginBox
        );

        StackPane centerPane = new StackPane(formContainer);
        centerPane.setPadding(new Insets(50));
        root.setCenter(centerPane);

        // Footer links
        HBox footer = new HBox(20, new Hyperlink("About StoryForge"), new Hyperlink("Help Center"), new Hyperlink("Privacy Policy"));
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(10));
        root.setBottom(footer);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("StoryForge - Sign Up");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
