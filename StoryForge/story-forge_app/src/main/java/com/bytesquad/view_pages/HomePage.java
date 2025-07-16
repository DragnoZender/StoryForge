package com.bytesquad.view_pages;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePage {

    Scene p2Scene;
    Stage p2Stage;

    Scene homePageScene, explorePageScene;
    Stage primary2Stage;

    
  
  
    public void setP2Scene(Scene p2Scene) {
        this.p2Scene = p2Scene;
    }

    public void setP2Stage(Stage p2Stage) {
        this.p2Stage = p2Stage;
    }

    public Scene createHomeScene(Runnable back){
        Text homePageTitle = new Text("Home Page");
        homePageTitle.setFont(Font.font("Cambria Math",40));

        // Text welcomeMsg = new Text("Welcome to app, "+ LoginPage.userName);

        Button logOutButton = new Button("Logout");
        logOutButton.setAlignment(Pos.TOP_CENTER);
        logOutButton.setBackground(Background.fill(Color.YELLOW));
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0){
                back.run();
            }
        });

        // Button explorePageButton = new Button("Explore");
        // explorePageButton.setAlignment(Pos.TOP_CENTER);
        // explorePageButton.setBackground(Background.fill(Color.YELLOW));
        // explorePageButton.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent arg0){
        //         initializeExplorePage();
        //         primary2Stage.setScene(explorePageScene);
        //     }
        // });

        VBox vb2 = new VBox(50);
        // vb2.getChildren().addAll(homePageTitle,welcomeMsg,logOutButton);
        vb2.setAlignment(Pos.CENTER);
        vb2.setBackground(Background.fill(Color.AQUA));

        Scene sc = new Scene(vb2,800,500);
        p2Stage.setScene(sc);
        p2Scene = sc;
        homePageScene =sc;
        primary2Stage = p2Stage;
        p2Stage.show();

        return sc;
    }



//     private void initializeExplorePage(){
//         ExplorePage explorePage = new ExplorePage();
//         explorePage.setP3Stage(primary2Stage);
//         explorePageScene = explorePage.createExploreScene(this::handleBackButton);
//         explorePage.setP3Scene(explorePageScene);
       

//     }

//         private void handleBackButton(){
//         primary2Stage.setScene(homePageScene);
//     }
}
