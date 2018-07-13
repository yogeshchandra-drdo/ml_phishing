/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.meta.Bagging;
import weka.classifiers.meta.Stacking;

/**
 *
 * @author antor
 */
public class usignMetaClassifier {
   
    static Stage window;
    
    static Button adaboost;
    static Button stacking;
    static Button bagging;
    
    
    public static void beginMetaClassifier(){
        window = new Stage();
        window.setTitle("UsingMetaClassifier");
        
        adaboost = new Button("AdaBoost");
        adaboost.setMinWidth(250);
        adaboost.setMaxWidth(250);
        adaboost.setOnAction(e-> {
            
            // Add the code for AdaBoost Classifier
            AdaBoostM1 adaboost = new AdaBoostM1();
            
            
            
        });
        
        bagging = new Button("Bagging");
        bagging.setMinWidth(250);
        bagging.setMaxWidth(250);
        bagging.setOnAction(e ->{
            // Add code for Bagging
        });
        
        stacking = new Button("Stacking");
        stacking.setMinWidth(250);
        stacking.setMaxWidth(250);
        stacking.setOnAction(e ->
        {
            
            
            // Add code for Stacking
        });
        
       
        
        VBox layout = new VBox(25);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(adaboost,bagging,stacking);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,600,600);
        
        window.setScene(scene);
        window.show();
    }
    
        
}
