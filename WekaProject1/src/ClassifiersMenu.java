/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import weka.core.converters.ArffLoader;
import weka.filters.supervised.instance.StratifiedRemoveFolds;


public class ClassifiersMenu {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws IOException, Exception{
       char ch;
        // 1. Taking the input file from the user
        Scanner s = new Scanner(System.in);
        System.out.println("Open the file for performing classfication");
        System.out.println("Type file location : ");
        String a = new String();
        a = s.nextLine();
        
        ArffLoader arffLoader = new ArffLoader();
        arffLoader.setSource(new File(a));
        Instances data = arffLoader.getDataSet();
        data.setClassIndex(data.numAttributes()-1);
        
        // Dividing the dataset into training and testing dataset
        
        // stratified remove folds to randomly split data
        StratifiedRemoveFolds filter = new StratifiedRemoveFolds();
        
        // set options for creating the subset of data
        
        String[] options = new String[6];
        int N,S;
        System.out.println("Select the number of folds");
        N = s.nextInt();
        System.out.println("What random seed do you want to set?");
        S = s.nextInt();
        
            options[0] = "-N";                 // indicate we want to set the number of folds                        
            options[1] = Integer.toString(N);  // split the data into five random folds
            options[2] = "-F";                 // indicate we want to select a specific fold
            options[3] = Integer.toString(1);  // select the first fold
            options[4] = "-S";                 // indicate we want to set the random seed
            options[5] = Integer.toString(S); 
     
        filter.setOptions(options);
        filter.setInputFormat(data);
        
        
        // test data
        filter.setInvertSelection(false);
        //applying filter for test data here
        Instances test = Filter.useFilter(data,filter);
        
        
        //train data
        filter.setInvertSelection(true);
        Instances train = Filter.useFilter(data, filter);
        
                   int choice = 9;

        do{
        //2. Preprocessing
            
          System.out.println("Do you want to preprocess the data (using remove FIlter)? y/n");
          ch = s.next().charAt(0);
          if(ch == 'y' || ch == 'Y'){
           System.out.println("Enter the indices of columns to be used");
           ArrayList<Integer> list = new ArrayList<Integer>();
           int ind = 0;
           while(ind!=-1){
               ind = s.nextInt();
               if(ind==-1)
                   break;
               list.add(ind);
           }
            
           int[] indicesOfColumnsToUse = new int[list.size()]; 
           for(int i = 0 ; i < list.size() ; i++){
               indicesOfColumnsToUse[i] = list.get(i);
           }
            
            // using remove filter
            Remove remove = new Remove();
            remove.setAttributeIndicesArray(indicesOfColumnsToUse);
            System.out.println("Set Invert Selection ? y/n");
            
            ch = s.next().charAt(0);
            if(ch == 'y' || ch == 'Y')
                remove.setInvertSelection(true);
            else 
                remove.setInvertSelection(false);
            
            remove.setInputFormat(train);
            
           Instances trainingSubset = Filter.useFilter(train,remove);
           
           Classifier cls = new J48();
            cls.buildClassifier(trainingSubset);
           Evaluation eval = new Evaluation(train);
             eval.evaluateModel(cls, test);
             
             
             }
           
          
          
          
        }while(choice!=9);
        
    }
    
    
    
}
