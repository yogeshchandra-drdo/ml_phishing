/*%
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author antor
 */

import java.util.*;

        import weka.core.converters.ConverterUtils.DataSource;    
        import java.util.Random;
        import weka.filters.Filter;
        import weka.filters.unsupervised.attribute.Remove;

        import java.io.File;
        import java.io.FileReader;
        import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.util.logging.Level;
        import java.util.logging.Logger;


        import weka.classifiers.meta.AdaBoostM1;
        import weka.classifiers.meta.Bagging;
        import weka.classifiers.meta.Vote;
        import weka.classifiers.Classifier;
        import weka.classifiers.Evaluation;
        import weka.classifiers.bayes.NaiveBayes;
        import weka.classifiers.evaluation.NominalPrediction;
        import weka.classifiers.functions.Logistic;
        import weka.classifiers.functions.SMO;
        import weka.classifiers.lazy.IBk;
        import weka.classifiers.lazy.KStar;
        import weka.classifiers.rules.DecisionTable;
        import weka.classifiers.rules.OneR;
        import weka.classifiers.rules.PART;
        import weka.classifiers.trees.DecisionStump;
        import weka.classifiers.trees.J48;
        import weka.classifiers.meta.Stacking;
        import weka.classifiers.rules.JRip;
        import weka.classifiers.rules.ZeroR;
        import weka.classifiers.trees.LMT;
        import weka.classifiers.trees.REPTree;
        import weka.classifiers.trees.RandomForest;
        import weka.classifiers.trees.RandomTree;



        import weka.core.FastVector;
        import weka.core.Instances;

        import weka.core.converters.ArffSaver;
        import weka.core.converters.CSVLoader;
        import weka.core.converters.ArffLoader;
        import weka.filters.supervised.instance.StratifiedRemoveFolds;

        import javafx.stage.*;
        import javafx.scene.*;
        import javafx.scene.layout.*;
        import javafx.scene.control.*;
          import javafx.geometry.*;
import javafx.scene.control.Label;

import javafx.scene.control.Button;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Start extends Application {
    Stage window;
    Button startButton;
    Button exitButton;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        
        TextField userInput = new TextField();
        userInput.setMaxWidth(300);
        Label label1 = new Label("Enter the file Location you want to work with :");
        label1.setMinWidth(250);
        HBox InputText = new HBox(label1,userInput);
        InputText.setSpacing(25);
        InputText.setPadding(new Insets(20,20,20,20));
        InputText.setAlignment(Pos.CENTER);
        
        startButton = new Button("Begin");
        startButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                try {
                    String filepath = userInput.getText();
                    ClassifierGUI.beginGUI(filepath);
                } catch (Exception ex) {
                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        exitButton = new Button("Exit");
        exitButton.setOnAction(e -> {
            System.out.println("Program Terminated successfully");
            window.close();
        });
        
        VBox layout = new VBox(50);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(InputText,startButton, exitButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,600,600);
        
        window.setScene(scene);
        window.setTitle("PhishingDataSet Analysis");
        window.show();
    }

    
    public static Instances[][] crossValidationSplit(Instances data, int numFolds) {
            Instances[][] split = new Instances[2][numFolds];
            
            for(int i = 0 ; i < numFolds ; i++){
                split[0][i] = data.trainCV(numFolds,i);
                split[1][i] = data.testCV(numFolds, i);
                
            }
            return split;
            
    }
    
    
 
}
