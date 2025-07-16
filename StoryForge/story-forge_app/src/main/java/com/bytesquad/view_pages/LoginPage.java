package com.bytesquad.view_pages;

import com.bytesquad.Control.FireBaseAuth;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class LoginPage extends Application {

    FireBaseAuth auth = new FireBaseAuth();

    @Override
    public void start(Stage myStage) {

        Stop[] backgroungGradient = new Stop[] {
            new Stop(0, Color.web("#4baae1ff")),
            new Stop(1, Color.web("#00ffaeff"))

        };
        Background background = new Background(new BackgroundFill(
                new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, backgroungGradient),
                CornerRadii.EMPTY, Insets.EMPTY));


                
        Text logoText = new Text("StoryForge");
        logoText.setFont(Font.font("Segoe Print", FontWeight.BOLD, 50));
        logoText.setFill(Color.WHITE);
        logoText.setEffect( new DropShadow(5, Color.BLACK));

        Text welcomeText = new Text("Welcome back to StoryForge!");
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        welcomeText.setFill(Color.BLACK);

        Text subtitleText = new Text("Continue the journey again. Log in to begin.");
        subtitleText.setFont(Font.font("Arial", 16));
        subtitleText.setFill(Color.BLACK);

        VBox logoBox = new VBox(logoText, welcomeText, subtitleText);
        logoBox.setAlignment(Pos.CENTER);
        logoBox.setSpacing(10);

        VBox loginForm = new VBox(15);
        loginForm.setPadding(new Insets(20));
        loginForm.setAlignment(Pos.CENTER);


        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setStyle("-fx-border-color: #30caa6; -fx-border-radius: 5;");


        Label passLabel = new Label("Password");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter your password");
        passField.setStyle("-fx-border-color: #30caa6; -fx-border-radius: 5;");

        Hyperlink forgotPassHyperlink = new Hyperlink("forgot Password");
        forgotPassHyperlink.setTextFill(Color.GRAY);

        HBox forgotPassBox = new HBox();
        forgotPassBox.setAlignment(Pos.CENTER_RIGHT);
        forgotPassBox.getChildren().add(forgotPassHyperlink);


        Button loginButton = new Button("Login to continue");
        loginButton.setPrefWidth(130);
        loginButton.setStyle("-fx-background-color: #FFE1AD; -fx-font-weight: bold; -fx-text-fill: #004d40; -fx-background-radius: 30; -fx-border-color: #004d40; -fx-border-width: 1px; -fx-border-radius: 20;");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent arg0){
                if(auth.LoginWithEmailAndPassword(emailField.getText() , passField.getText())){
                    System.out.println("Successful Login");
                }else{
                    System.out.println("Login Error");
                }
            }
        });


        Text noAccount = new Text("Don't have an account?");
        Hyperlink signUpLink = new Hyperlink("Sign Up");

        HBox signupBox = new HBox();
        signupBox.setAlignment(Pos.CENTER);
        signupBox.setSpacing(5);
        signupBox.getChildren().addAll(noAccount, signUpLink);

        VBox userInputcard = new VBox(10, emailLabel, emailField, passLabel, passField, forgotPassBox, loginButton, signupBox);
        userInputcard.setPadding(new Insets(30));
        userInputcard.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        userInputcard.setMaxWidth(350);
        userInputcard.setAlignment(Pos.CENTER);
        userInputcard.setEffect(new DropShadow(5, Color.BLACK));


        Hyperlink about = new Hyperlink("About StoryForge");
        about.setTextFill(Color.BLACK);

        Hyperlink help = new Hyperlink("Help Center");
        help.setTextFill(Color.BLACK);

        Hyperlink privacy = new Hyperlink("Privacy Policy");
        privacy.setTextFill(Color.BLACK);


        HBox extraHyperLinks = new HBox(30);
        extraHyperLinks.getChildren().addAll(about,help,privacy);
        extraHyperLinks.setAlignment(Pos.CENTER);
        extraHyperLinks.setPadding(new Insets(20, 0, 10, 0));


        VBox mainVBox = new VBox(30, logoBox, userInputcard, extraHyperLinks);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPadding(new Insets(40,40,40,40));
        mainVBox.setBackground(background);

        Scene sc = new Scene(mainVBox, 800, 600);

        myStage.setTitle("StoryForge");
        
        myStage.getIcons().add(new Image("Assests\\Images\\StoryForgeLogo.png")); 
        myStage.setScene(sc);
        myStage.show();
    }

}
