/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.Logistic;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
import weka.classifiers.rules.DecisionTable;
import weka.classifiers.rules.JRip;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.LMT;
import weka.classifiers.trees.REPTree;

/**
 *
 * @author antor
 */
public class MetaClassifierMenu{
    
    public static String selecsString = "";
    static String userSelected;
    static Classifier[] selections;
    static Button set;
    static Button submitButton;
    static ComboBox<String> combobox;
    static Label commonlabel;
    static Label stackingLabel;
    static CheckBox box1;
    static CheckBox box2;
    static CheckBox box3;
    static CheckBox box4;
    static CheckBox box5;
    static CheckBox box6;
    static CheckBox box7;
    static CheckBox box8;
    static CheckBox box9;
    static CheckBox box10;
    static CheckBox box11;
    
    public static String MenuWindowC(){
    Stage window = new Stage();
    window.setTitle("Classifier Selector");
    window.setMinWidth(300);
     window.initModality(Modality.APPLICATION_MODAL);
    Label label = new Label();
    label.setText("Select your classifier");
    
    combobox = new ComboBox<>();
    combobox.setPromptText("Select the classifier you want to apply");
    combobox.getItems().addAll("Naive Bayes", "Logistic","SMO","IBk","Decision Table","JRip","PART","Decision Stump","J48","LMT","REPTree");
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
    
  
    
    public static Classifier[] MenuWindowStacking(){
    Stage window = new Stage();
    window.setTitle("Classifier Selector");
    window.setMinWidth(300);
     window.initModality(Modality.APPLICATION_MODAL);
    Label label = new Label();
    label.setText("Select your classifiers");
    
    box1 = new CheckBox("Naive Bayes");
    box2 = new CheckBox("Logistic");
    box3 = new CheckBox("SMO");
    box4 = new CheckBox("IBk");
    box5 = new CheckBox("Decision Table");
    box6 = new CheckBox("JRip");
    box7 = new CheckBox("PART");
    box8 = new CheckBox("Decision Stump");
    box9 = new CheckBox("J48");
    box10 = new CheckBox("LMT");
    box11 = new CheckBox("REPTree");
    
    submitButton = new Button("Submit Choices !");
    submitButton.setOnAction(e-> {
        int numberOfSelected = 0;
        int i = 1;
        ArrayList<Integer> selecs = new ArrayList<>();
        if(box1.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += "Naive Bayes -";
            i++;
            
        }else{
            i++;
        }
        if(box2.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " Logistic -";
            i++;
        }else{
            i++;
        }
        if(box3.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " SMO -";
            i++;
        }else{
            i++;
        }
        if(box4.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " IBk -";
            i++;
        }else{
            i++;
        }
        if(box5.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " Decision Table -";
            i++;
        }else{
            i++;
        }
        if(box6.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " JRip -";
            i++;
        }else{
            i++;
        }
        if(box7.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " PART -";
            i++;
        }else{
            i++;
        }
        if(box8.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " Decision Stump -";
            i++;
        }else{
            i++;
        }
        if(box9.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " J48 -";
            i++;
        }else{
            i++;
        }
        if(box10.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " LMT -";
            i++;
        }else{
            i++;
        }
        if(box11.isSelected()){
            numberOfSelected++;
            selecs.add(i);
            selecsString += " REPTree -";
            i++;
        }else{
            i++;
        }
        
        selections = new Classifier[numberOfSelected];
        for(int j = 0 ; j < selecs.size() ; j++){
            switch(selecs.get(j)){
                case 1:
                    selections[j] = new NaiveBayes();
                    break;
                case 2:
                    selections[j] = new Logistic();
                    break;
                case 3:
                    selections[j] = new SMO();
                    break;
                case 4:
                    selections[j] = new IBk();
                    break;
                case 5:
                    selections[j] = new DecisionTable();
                    break;
                case 6:
                    selections[j] = new JRip();
                    break;
                case 7:
                    selections[j] = new PART();
                    break;
                case 8:
                    selections[j] = new DecisionStump();
                    break;
                case 9:
                    selections[j] = new J48();
                    break;
                case 10:
                    selections[j] = new LMT();
                    break;
                case 11:
                    selections[j] = new REPTree();
                    break;
                   
            }
        }
        
        
        window.close();
    });
    
    VBox layout = new VBox(50);
    layout.setPadding(new Insets(20,20,20,20));
    layout.getChildren().addAll(box1,box2,box3,box4,box5,box6,box7,box8,box9,box10,box11,submitButton);
    layout.setAlignment(Pos.CENTER);
    Scene scene = new Scene(layout, 600, 600);
        
    window.setScene(scene);
    window.showAndWait();
        
    return selections;
}
    
    
    
    
    
    
    
    
}
    
    
    
    

