/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author antor
 */
public class MetaClassifierMenu{
    
    static String userSelected;
   
    static Button set;
    static ComboBox<String> combobox;
    static Label commonlabel;
    static Label stackingLabel;
    
    public static String MenuWindowC(){
    Stage window = new Stage();
    window.setTitle("Classifier Selector");
    window.setMinWidth(300);
     window.initModality(Modality.APPLICATION_MODAL);
    Label label = new Label();
    label.setText("Select your classifier");
    
    combobox = new ComboBox<>();
    combobox.setPromptText("Select the classifier you want to apply");
    combobox.getItems().addAll("Naive Bayes", "Logistic","SMO","IBk","Decision table","JRip","PART","Decision Stump","J48","LMT","REPTree");
    combobox.setMinWidth(300);
    combobox.setMaxWidth(300);
    combobox.setOnAction(e->  {
        userSelected = combobox.getValue();
        window.close();
         
    });
    
    VBox layout = new VBox(50);
    layout.setPadding(new Insets(20,20,20,20));
    layout.getChildren().addAll(combobox);
    layout.setAlignment(Pos.CENTER);
    Scene scene = new Scene(layout, 500, 600);
        
    window.setScene(scene);
    window.showAndWait();
        
    return userSelected;
}
    
  
    
    
    
    
    
    
}
    
    
    
    

