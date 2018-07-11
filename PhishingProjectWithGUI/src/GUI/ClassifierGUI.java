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
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.LMT;
import weka.classifiers.trees.REPTree;
import weka.classifiers.trees.RandomForest;
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
           Evaluation eval = null;
           Classifier cls = new NaiveBayes();
           
            for(int j = 0 ; j < training.length ; j++){
                try {
                    eval = classify(cls, training[j],testing[j]);
                    predictions.appendElements(eval.predictions());
                   
                } catch (Exception ex) {
                    Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
                }}    
             //   resultWindow.result(eval,predictions);
             
             double accuracy = calculateAccuracy(predictions);
             
              System.out.println("Accuracy of "+ cls.getClass().getSimpleName() + ": "
                              + String.format("%.2f%%",accuracy) + "\n-----------------------"   );
            

        });
        
        Trees = new ComboBox<>();
        Trees.setPromptText("Select a Tree Classifier");
        Trees.getItems().addAll("Random Forest","J48", "RIPTree","LMT","Decision Stump");
        Trees.setMinWidth(300);
        Trees.setMaxWidth(300);
        Trees.setOnAction(e -> {
            Evaluation eval = null;
            Classifier cls[]={
                new RandomForest(),
                new J48(),
                new REPTree(),
                new LMT(),
                new DecisionStump()
            };
            
            
            for(int j = 0; j < training.length;j++){
                eval=classify(cls[])
            }
        });
        
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
       
        public static double calculateAccuracy(FastVector predictions) {
            double correct = 0;
            
            for(int i = 0 ; i < predictions.size() ; i++){
                NominalPrediction np = (NominalPrediction) predictions.elementAt(i);
                if(np.predicted() == np.actual()){
                    correct++;
                }
            }
            return 100* correct/ predictions.size();
    }
       
  
 
    
    
    
}
