/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.ClassifierGUI.calculateAccuracy;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.evaluation.Evaluation;
import weka.core.FastVector;

/**
 *
 * @author antor
 */
public class PrintOutput {
        public static void printResults(Evaluation validation, FastVector predictionsN, String userSelected){
            System.out.println("!-------------- " + userSelected + " ----------------------!" );
            double accuracy = calculateAccuracy(predictionsN);
           //  double fmeasure = validation.fMeasure(classIndex);
             String cMatrix = null;
             String strSummary = validation.toSummaryString();
             StringBuilder st = new StringBuilder();
            try {
                cMatrix = validation.toMatrixString();
            } catch (Exception ex) {
                Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println("\n\nAccuracy Measure :" + accuracy);
             System.out.println("Confusion Matrix :  " + cMatrix);
             System.out.println("Summary String : " + strSummary);
             //st.append("F-Measure :").append(validation.fMeasure(classIndex)).append("\n");
             double tp = validation.numTruePositives(0);
             //System.out.println(tp);
             double fp = validation.numFalsePositives(0);
             //System.out.println(fp);
             double tn = validation.numTrueNegatives(0);
            // System.out.println(tn);
             double fn = validation.numFalseNegatives(0);
             //System.out.println(fn);
             double roc = validation.areaUnderROC(0);
             double prec = validation.precision(0);
             double recall  = validation.recall(0);
             double fmeasure = validation.fMeasure(0);
             System.out.println("Area Under ROC :" + roc + "\n");
             st.append("Weighted AreaUnderROC: ").append(validation.weightedAreaUnderROC()).append("\n\n");
             st.append("True Positives :").append(Double.toString(tp)).append("\n");
             st.append("False Positives :").append(Double.toString(fp)).append("\n");
             st.append("True Negatives :").append(Double.toString(tn)).append("\n");
             st.append("False Negatives :").append(Double.toString(fn)).append("\n\n");
             st.append("Precision  :").append(Double.toString(prec)).append("\n");
             st.append("Recall :").append(Double.toString(recall)).append("\n");
             st.append("F-Measure :").append(Double.toString(fmeasure)).append("\n");
             System.out.println(st);
             
             
             System.out.println("Successfully evaluated using " + userSelected);
             System.out.println("------------------------------------------------------");
        }
        
         public static void printResultsMetaClassifier(Evaluation validation, FastVector predictionsN, String userSelected){
             
           System.out.println("!-------------- " + userSelected + " ----------------------!" );
            double accuracy = calculateAccuracy(predictionsN);
           //  double fmeasure = validation.fMeasure(classIndex);
             String cMatrix = null;
             String strSummary = validation.toSummaryString();
             StringBuilder st = new StringBuilder();
            try {
                cMatrix = validation.toMatrixString();
            } catch (Exception ex) {
                Logger.getLogger(ClassifierGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println("\n\nAccuracy Measure :" + accuracy);
             System.out.println("Confusion Matrix :  " + cMatrix);
             System.out.println("Summary String : " + strSummary);
             //st.append("F-Measure :").append(validation.fMeasure(classIndex)).append("\n");
             double tp = validation.numTruePositives(0);
             //System.out.println(tp);
             double fp = validation.numFalsePositives(0);
             //System.out.println(fp);
             double tn = validation.numTrueNegatives(0);
            // System.out.println(tn);
             double fn = validation.numFalseNegatives(0);
             //System.out.println(fn);
             double roc = validation.areaUnderROC(0);
             double prec = validation.precision(0);
             double recall  = validation.recall(0);
             double fmeasure = validation.fMeasure(0);
             System.out.println("Area Under ROC :" + roc + "\n");
             st.append("Weighted AreaUnderROC: ").append(validation.weightedAreaUnderROC()).append("\n\n");
             st.append("True Positives :").append(Double.toString(tp)).append("\n");
             st.append("False Positives :").append(Double.toString(fp)).append("\n");
             st.append("True Negatives :").append(Double.toString(tn)).append("\n");
             st.append("False Negatives :").append(Double.toString(fn)).append("\n\n");
             st.append("Precision  :").append(Double.toString(prec)).append("\n");
             st.append("Recall :").append(Double.toString(recall)).append("\n");
             st.append("F-Measure :").append(Double.toString(fmeasure)).append("\n");
             System.out.println(st);
             
             
             System.out.println("Successfully evaluated using " + userSelected);
             System.out.println("------------------------------------------------------");
                    
        }
        
       
}
