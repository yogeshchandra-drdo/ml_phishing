/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antoreep Jana
 */
import weka.core.converters.ConverterUtils.DataSource;    
import java.util.Random;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;



import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.rules.DecisionTable;
import weka.classifiers.rules.OneR;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.trees.J48;
import weka.core.FastVector;
import weka.core.Instances;

import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;



public class WekaProject {
    
    
    
    
    
    public static void main(String[] args) throws Exception{
        //1.Loading of dataset
        // reading and storing the instances
        BufferedReader reader = readDataFile("Training Dataset.arff");
        Instances data = new Instances(reader);
        data.setClassIndex(data.numAttributes()-1);
        reader.close();
        
        
        //2.Do the 10-split cross validation
        
        Instances[][] split = crossValidationSplit(data,10);
        
        
        // Seperate the split into training and testing arrays
        Instances[] trainingSplits = split[0];
        Instances[] testingSplits = split[1];
        
        // Use a set of classifiers 
        
        Classifier[] models = {
            new J48(), // decision tree
            new PART(),
            new DecisionTable(),   // decision table majority classifier
            new DecisionStump()   // one-level decision tree
            
        };
                
          
        // Run for each model
        
        for(int i = 0 ; i < models.length ; i++){
            // Collect every group of predictions for current model in FastVector
            FastVector predictions = new FastVector();
            
            // for each training-testing split pair, train and test the classifier
            
           for(int j = 0 ; j < trainingSplits.length ; j++){
               Evaluation validation = classify(models[i], trainingSplits[j],testingSplits[j]);
           
                predictions.appendElements(validation.predictions());
                
           }
           
           // Calculate overall accuracy of current classifier on all splits
           double accuracy = calculateAccuracy(predictions);
           
           // now printing the accuracy of the classifier
           
           System.out.println("Accuracy of "+ models[i].getClass().getSimpleName() + ": "
                              + String.format("%.2f%%",accuracy) + "\n-----------------------"   );
            
        }
        
        
        
    }

    public static Instances[][] crossValidationSplit(Instances data, int numFolds) {
            Instances[][] split = new Instances[2][numFolds];
            
            for(int i = 0 ; i < numFolds ; i++){
                split[0][i] = data.trainCV(numFolds,i);
                split[1][i] = data.testCV(numFolds, i);
                
            }
            return split;
            
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

    public static BufferedReader readDataFile(String filename) {
        BufferedReader inputReader = null;
        try{
            inputReader = new BufferedReader(new FileReader(filename));
        }catch(FileNotFoundException ex){
            System.err.println("File not found: "+ filename);
        }
        return inputReader;
    }
}
