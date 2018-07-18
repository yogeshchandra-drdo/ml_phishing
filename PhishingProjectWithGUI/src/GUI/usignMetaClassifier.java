/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import static GUI.ClassifierGUI.data;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.Logistic;
import weka.classifiers.functions.SMO;
import weka.classifiers.lazy.IBk;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.meta.Bagging;
import weka.classifiers.meta.Stacking;
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
          String answer = MetaClassifierMenu.MenuWindowC();
           
              AdaBoostM1 m1 = new AdaBoostM1();
             switch(answer){
                 case "Naive Bayes":
                     m1.setClassifier(new NaiveBayes());
                     break;
                 
                 case "Logistic":
                     m1.setClassifier(new Logistic());
                     break;
                 case "SMO":
                     m1.setClassifier(new SMO());
                     break;
                 case "IBk":
                     m1.setClassifier(new IBk());
                     break;
                 case "Decision Table":
                     m1.setClassifier(new DecisionTable());
                     break;
                 case "JRip":
                     m1.setClassifier(new JRip());
                     break;
                 case "PART":
                     m1.setClassifier(new PART());
                     break;
                 case "Decision Stump":
                     m1.setClassifier(new DecisionStump());
                     break;
                 case "J48":
                     m1.setClassifier(new J48());
                     break;
                 case "LMT":
                     m1.setClassifier(new LMT());
                     break;
                 case "REPTree":
                     m1.setClassifier(new REPTree());
                     break;            
                 
             }
            m1.setNumIterations(20);
            m1.buildClassifier(training);
            
            
        });
        
        bagging = new Button("Bagging");
        bagging.setMinWidth(250);
        bagging.setMaxWidth(250);
        bagging.setOnAction(e ->{
            // Add code for Bagging
            
            String selection = MetaClassifierMenu.MenuWindowC();
            Bagging bagger = new Bagging();
            
            switch(selection){
                case "Naive Bayes":
                     bagger.setClassifier(new NaiveBayes());
                     break;
                 
                 case "Logistic":
                     bagger.setClassifier(new Logistic());
                     break;
                 case "SMO":
                     bagger.setClassifier(new SMO());
                     break;
                 case "IBk":
                     bagger.setClassifier(new IBk());
                     break;
                 case "Decision Table":
                     bagger.setClassifier(new DecisionTable());
                     break;
                 case "JRip":
                     bagger.setClassifier(new JRip());
                     break;
                 case "PART":
                     bagger.setClassifier(new PART());
                     break;
                 case "Decision Stump":
                     bagger.setClassifier(new DecisionStump());
                     break;
                 case "J48":
                     bagger.setClassifier(new J48());
                     break;
                 case "LMT":
                     bagger.setClassifier(new LMT());
                     break;
                 case "REPTree":
                     bagger.setClassifier(new REPTree());
                     break;       
   
            }
            
            bagger.setNumIterations(25);
            bagger.buildClassifier(training);
            
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
