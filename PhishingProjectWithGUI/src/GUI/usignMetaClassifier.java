/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author antor
 */
public class usignMetaClassifier extends Application{
   
    Stage window;
    
    Button adaboost;
    Button stacking;
    Button bagging;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        primaryStage = window;
        window.setTitle("UsingMetaClassifier");
        
        adaboost = new Button("AdaBoost");
        adaboost.setOnAction(e-> {
            
            // Add the code for AdaBoost Classifier
            
            
        });
        
        bagging = new Button("Bagging");
        bagging.setOnAction(e ->{
            // Add code for Bagging
        });
        
        stacking = new Button("Stacking");
        stacking.setOnAction(e ->
        {
            // Add code for Stacking
        });
        
    }
    
        
}
