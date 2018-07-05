/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import static GUI.Start.crossValidationSplit;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.FastVector;
import weka.core.Instances;
import weka.core.converters.ArffLoader;



/**
 *
 * @author antor
 */
public class ClassifierGUI {
   
    public static FastVector predictions = new FastVector();
   static Button naivebayesClassifier;
  static  ComboBox<String> Trees;
   static ComboBox<String> Functions;
   static ComboBox<String> Rules;
   static ComboBox<String> Lazy;
   static Button UseMetaClassifier;
    public static int classIndex;
    
        public static void beginGUI() throws IOException,Exception{
        Stage window = new Stage();
        window.setTitle("CLASSIFIER EXPLORER");
        
        // Getting Dataset
        // For now, Setting DataSet as Default to Mohammed Dataset
        Scanner s = new Scanner(System.in);
        String a = new String();
            System.out.println("File Location: \n");
            a = s.nextLine();
        ArffLoader arffloader = new ArffLoader();
        arffloader.setSource(new File(a));
        Instances data = arffloader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);
        classIndex = data.numAttributes() -1;
        
        
        // Splitting the data into training and testing dataset
        Instances[][] split = crossValidationSplit(data,10);
        
        //traingarray Split
        Instances[] training = split[0];
        // testing array split
        Instances[] testing = split[1];
        
        
        
        // Interface Buidling
        naivebayesClassifier = new Button("Apply Naive Bayes Classifier");
        naivebayesClassifier.setMinWidth(300);
        naivebayesClassifier.setMaxWidth(300);
        naivebayesClassifier.setOnAction(e -> {
            // Add code for Naives bayes Classifier
           
            for(int j = 0 ; j < training.length ; j++){
                try {
                    Evaluation validation = classify(new NaiveBayes(), training[j],testing[j]);
                    predictions.appendElements(validation.predictions());
                    resultWindow.result(validation,predictions);
                    window.wait(6000);
                    window.close();
                    
                } catch (Exception ex) {
                    Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
                }}    
        });
        
        Trees = new ComboBox<>();
        Trees.setPromptText("Select a Tree Classifier");
        Trees.getItems().addAll("Random Forest","J48", "RIPTree","LMT","Decision Stump");
        Trees.setMinWidth(300);
        Trees.setMaxWidth(300);
        
        
        Functions = new ComboBox<>();
        Functions.setPromptText("Select a Function Classifier");
        Functions.getItems().addAll("Logistic","SMO");
        Functions.setMinWidth(300);
        Functions.setMaxWidth(300);
        
        
        Rules = new ComboBox<>();
        Rules.setPromptText("Select a Rule Classifier");
        Rules.getItems().addAll("JRip","Decision Table","OneR","PArT");
        Rules.setMinWidth(300);
        Rules.setMaxWidth(300);
        
        Lazy = new ComboBox<>();
        Lazy.setPromptText("Select a Lazy Classifier");
        Lazy.getItems().addAll("IBk(KNN)","KStar" );
        Lazy.setMinWidth(300);
        Lazy.setMaxWidth(300);
        
        
        UseMetaClassifier = new Button("Use a Meta Classifier");
        UseMetaClassifier.setMinWidth(300);
        UseMetaClassifier.setMaxWidth(300);
        
        
        VBox layout = new VBox(25);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(naivebayesClassifier,Trees,Functions,Rules,Lazy,UseMetaClassifier);
        layout.setAlignment(Pos.CENTER);
        
        
        Scene scene = new Scene(layout,600,500);
        window.setScene(scene);
        window.setMinWidth(500);
        window.setMinHeight(300);
        window.show();
         
    
    }
        
        
        
       public static Evaluation classify(Classifier model, Instances trainingSet, Instances testingSet) throws Exception {

                Evaluation validation = new Evaluation(trainingSet);

                model.buildClassifier(trainingSet);
                validation.evaluateModel(model, trainingSet);

                return validation;

            }    
    
    
    
}
