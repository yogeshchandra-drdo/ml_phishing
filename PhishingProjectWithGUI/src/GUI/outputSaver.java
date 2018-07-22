/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author antor
 */
public class outputSaver {
    
    private static String pathname = null; 
    private static final String header = "Classifier_Name, Accuracy, Precision, Recall, F-Measure\n";
    public static void save(String data, double accuracy, double precision, double recall, double fmeasure) throws IOException{
        Scanner s = new Scanner(System.in);
        BufferedWriter bw = null;
        FileWriter fw = null;
        System.out.println("Enter the path where you want to save results :");
        pathname = s.nextLine();
        try{
            //data = "\nOk,What\nNow,Be";
            File file = new File(pathname);
            
            // if the file doesn't exist, then create it
            if(!file.exists()){
                file.createNewFile();
                fw = new FileWriter(file.getAbsoluteFile(),true);
                bw = new BufferedWriter(fw);
                bw.write(header);
            }
            
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            
            bw.write(data +"," +  accuracy + ","+ precision + "," + recall + "," + fmeasure + "\n");
            System.out.println("Done! Successfully Saved!");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                
                if(bw != null){
                    bw.close();
                }
                
                if(fw != null){
                    fw.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
