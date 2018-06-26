/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antoreep Jana
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
//import javafx.scene.stage.Stage;
import javafx.stage.Stage;



public class Main extends Application{
    Button button;
    
    public static void main(String[] args){
        launch(args);  
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
      primaryStage.setTitle("GUI WEKA CLASSIFIERS");
      button = new Button();
      button.setText("Start");
      
      StackPane layout = new StackPane();
      layout.getChildren().add(button);
      
      Scene scene = new Scene(layout,300,250);
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    
    
}
