/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import static GUI.ClassifierGUI.calculateAccuracy;
import static GUI.ClassifierGUI.data;
import static GUI.Start.crossValidationSplit;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.NominalPrediction;
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
import weka.core.FastVector;
import weka.core.Instances;

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
        
         data.setClassIndex(data.numAttributes() - 1);
        // Splitting the data into training and testing dataset
        Instances[][] split = crossValidationSplit(data,10);
        
        //traingarray Split
        Instances[] training = split[0];
        // testing array split
        Instances[] testing = split[1];
        
        adaboost = new Button("AdaBoost");
        adaboost.setMinWidth(250);
        adaboost.setMaxWidth(250);
        adaboost.setOnAction(e-> {
            
            // Add the code for AdaBoost Classifier
          String answer = MetaClassifierMenu.MenuWindowC();
            System.out.println("Please wait....while the system calculates.....");
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
             FastVector predictions = new FastVector();
           
            Evaluation validation = null;
            
             for(int j = 0 ; j < training.length ; j++){
                    try {
                        validation = classify(m1, training[j], testing[j]);
                        predictions.appendElements(validation.predictions());
                    } catch (Exception ex) {
                        Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
        }
            PrintOutput.printResults(validation, predictions,"AdaBoost");
            double accuracy = calculateAccuracy(predictions);
            double roc = validation.areaUnderROC(0);
            double fmeasure = validation.fMeasure(0);
            try {
                outputSaver.save("AdaBoostM1 " + " : " + "Classifier Applied ->" + answer, accuracy, fmeasure, roc, fmeasure);
            } catch (IOException ex) {
                Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        });
        
        bagging = new Button("Bagging");
        bagging.setMinWidth(250);
        bagging.setMaxWidth(250);
        bagging.setOnAction(e ->{
            // Add code for Bagging
            
            String selection = MetaClassifierMenu.MenuWindowC();
            System.out.println("Please wait while the system calculates the result.....");
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
//            bagger.buildClassifier(training);
             FastVector predictions = new FastVector();
           
            Evaluation validation = null;
            
             for(int j = 0 ; j < training.length ; j++){
                    try {
                        validation = classify(bagger, training[j], testing[j]);
                        predictions.appendElements(validation.predictions());
                    } catch (Exception ex) {
                        Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
        }
           
            PrintOutput.printResults(validation, predictions,"Bagging");
            double accuracy = calculateAccuracy(predictions);
            double roc = validation.areaUnderROC(0);
            double fmeasure = validation.fMeasure(0);
            try {
                outputSaver.save("Bagging " + " : " + "Classifier Applied ->" + selection, accuracy, fmeasure, roc, fmeasure);
            } catch (IOException ex) {
                Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        });
        
        stacking = new Button("Stacking");
        stacking.setMinWidth(250);
        stacking.setMaxWidth(250);
        stacking.setOnAction((ActionEvent e) ->
        {
            Stacking stacker = new Stacking();
            // First set the meta classifier (Base Classifier)
            String base_classifier = MetaClassifierMenu.MenuWindowC();
            switch(base_classifier){
                case "Naive Bayes":
                     stacker.setMetaClassifier(new NaiveBayes());
                     break;
                 
                 case "Logistic":
                     stacker.setMetaClassifier(new Logistic());
                     break;
                 case "SMO":
                     stacker.setMetaClassifier(new SMO());
                     break;
                 case "IBk":
                     stacker.setMetaClassifier(new IBk());
                     break;
                 case "Decision Table":
                     stacker.setMetaClassifier(new DecisionTable());
                     break;
                 case "JRip":
                     stacker.setMetaClassifier(new JRip());
                     break;
                 case "PART":
                     stacker.setMetaClassifier(new PART());
                     break;
                 case "Decision Stump":
                     stacker.setMetaClassifier(new DecisionStump());
                     break;
                 case "J48":
                     stacker.setMetaClassifier(new J48());
                     break;
                 case "LMT":
                     stacker.setMetaClassifier(new LMT());
                     break;
                 case "REPTree":
                     stacker.setMetaClassifier(new REPTree());
                     break;       
   
            }
            //
            Classifier[] selections = MetaClassifierMenu.MenuWindowStacking();
            stacker.setClassifiers(selections);
            System.out.println("Please wait while the system builds and evaluates the model....");
            
//            
            FastVector predictions = new FastVector();
////           
            Evaluation validation = null;
//            
             for(int j = 0 ; j < training.length ; j++){
                    try {
                        validation = classify(stacker, training[j], testing[j]);
                        predictions.appendElements(validation.predictions());
                    } catch (Exception ex) {
                        Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
             }
             
            PrintOutput.printResults(validation, predictions,"Stacking");
            double accuracy = calculateAccuracy(predictions);
            double roc = validation.areaUnderROC(0);
            double fmeasure = validation.fMeasure(0);
            try {
                outputSaver.save("Stacking " + " : " + "Meta Classifier Applied ->" + base_classifier + " ; Base Classifiers Applied : " + MetaClassifierMenu.selecsString, accuracy, fmeasure, roc, fmeasure);
                MetaClassifierMenu.selecsString = "";
            } catch (IOException ex) {
                Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
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
