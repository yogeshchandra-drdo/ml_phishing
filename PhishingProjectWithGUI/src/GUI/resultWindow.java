/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import static GUI.ClassifierGUI.classIndex;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import weka.classifiers.Evaluation;
import weka.core.FastVector;
/**
 *
 * @author antor
 */
public class resultWindow {
    
    static Stage window;
    static Label labelf;
    static Label labelacc;
    static Label labelroc;
    
 public static void result(Evaluation validation, FastVector predictions){
     window = new Stage();
     window.setTitle("Results Obtained...");
     
     // F Measure
     labelf = new Label("F - Measure :");
     
     // Text Field F measure
     TextField fmeasure = new TextField();
     fmeasure.setText(validation.fMeasure(classIndex) + " ");
     // Accuracy Percentage
    /* labelacc = new Label("Accuracy - Measure :");
     TextField accPred = new TextField();
     accPred.setText(validation.predictions() + " ");
     
     // roc measure
     labelroc = new Label("ROC - Measure :");
     TextField rocmeasure = new TextField();
     rocmeasure.setText(validation.areaUnderROC(classIndex)+ " ");
 */
     // Creating Horizontal Box 1
     HBox hbox1 = new HBox();
     hbox1.setPadding(new Insets(10,10,10,10));
     hbox1.getChildren().addAll(labelf,fmeasure);
     
     // horizontal Box2
    /* 
     HBox hbox2 = new HBox();
     hbox2.setPadding(new Insets(10,10,10,10));
     hbox2.getChildren().addAll(labelacc,accPred);
        
     
     
     // Horizontal Box3
     
     HBox hbox3 = new HBox();
     hbox3.setPadding(new Insets(10,10,10,10));
     hbox3.getChildren().addAll(labelroc,rocmeasure);
     
     */
     VBox layout = new VBox(40);
     layout.setPadding(new Insets(20,20,20,20));
      layout.setAlignment(Pos.CENTER);
      layout.getChildren().addAll(hbox1);
      
      
      Scene scene = new Scene(layout,500,600);
      window.setScene(scene);
      window.show();
      
     
 }   
 
}
