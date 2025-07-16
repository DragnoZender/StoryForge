package com.bytesquad.view_pages;

import com.bytesquad.Control.FireBaseAuth;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUpPage2 extends Application{

    FireBaseAuth auth = new FireBaseAuth();

    @Override
    public void start(Stage myStage) throws Exception {

                Stop[] backgroungGradient = new Stop[] {
            new Stop(0, Color.web("#4baae1ff")),
            new Stop(1, Color.web("#00ffaeff"))

            // new Stop(0, Color.web("#1AFFFF")),
            // new Stop(0.2, Color.web("#007a7aff")),
            // new Stop(0.4, Color.web("#00e7e7ff")),
            // new Stop(0.6, Color.web("#008080")),
            // new Stop(0.8, Color.web("#00B3B3")),
            // new Stop(1, Color.web("#00E6E6")),
        };
        Background background = new Background(new BackgroundFill(
                new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, backgroungGradient),
                CornerRadii.EMPTY, Insets.EMPTY));
            
        Text logoText = new Text("StoryForge");
        logoText.setFont(Font.font("Segoe Print", FontWeight.BOLD, 50));
        logoText.setFill(Color.WHITE);
        logoText.setEffect( new DropShadow(5, Color.BLACK));

        Text welcomeText = new Text("Welcome to the StoryForge!");
        welcomeText.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        welcomeText.setFill(Color.BLACK);

        Text subtitleText = new Text("Create an account to begin.");
        subtitleText.setFont(Font.font("Arial", 16));
        subtitleText.setFill(Color.BLACK);

        VBox logoBox = new VBox(logoText, welcomeText, subtitleText);
        logoBox.setAlignment(Pos.CENTER);
        logoBox.setSpacing(10);

        VBox signUpForm = new VBox(10);
        signUpForm.setPadding(new Insets(20));
        signUpForm.setAlignment(Pos.CENTER);

        Label userNameLabel = new Label("Create a UserName");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Choose a unique username");
        usernameField.setStyle("-fx-border-color: #30caa6; -fx-border-radius: 5;");

        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setStyle("-fx-border-color: #30caa6; -fx-border-radius: 5;");


        Label passLabel = new Label("Password");
        PasswordField passField = new PasswordField();
        passField.setPromptText("create your password");
        passField.setStyle("-fx-border-color: #30caa6; -fx-border-radius: 5;");

        Label cPassLabel = new Label("Confirm Password");
        PasswordField cPassField = new PasswordField();
        cPassField.setPromptText("Enter your password again");
        cPassField.setStyle("-fx-border-color: #30caa6; -fx-border-radius: 5;");

        Text displaytx = new Text();
        Button signUPButton = new Button("Create my account");
        signUPButton.setPrefWidth(130);
        signUPButton.setStyle("-fx-background-color: #FFE1AD; -fx-font-weight: bold; -fx-text-fill: #004d40; -fx-background-radius: 30; -fx-border-color: #004d40; -fx-border-width: 1px; -fx-border-radius: 20;");
        signUPButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent arg0){
                if((passField.getText()).equals(cPassField.getText())){
                
                    if(auth.signUpWithEmailAndPassword(emailField.getText(), passField.getText())){
                        System.out.println("Signup successful");
                    }else{
                        System.out.println("Error in signUp");
                    }
                }else{
                    displaytx.setText("Password mismatched, Enter again");
                }

            }
            });


        Hyperlink loginLink = new Hyperlink("Log In");
        Text already = new Text("Already have an account? ");
        HBox loginBox = new HBox(5, already, loginLink);
        loginBox.setAlignment(Pos.CENTER);
       
        signUpForm.getChildren().addAll(userNameLabel,usernameField,emailLabel,emailField,passLabel,passField,cPassLabel,cPassField,signUPButton,displaytx,loginBox);
        signUpForm.setPadding(new Insets(30));
        signUpForm.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        signUpForm.setMaxWidth(350);
        signUpForm.setAlignment(Pos.CENTER);
        signUpForm.setEffect(new DropShadow(5, Color.BLACK));


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

        VBox mainVBox = new VBox(15, logoBox,signUpForm, extraHyperLinks);
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
