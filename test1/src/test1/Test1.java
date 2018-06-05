/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToString;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.filters.unsupervised.attribute.Reorder;

public class Test1 {
    public static void main(String args[]) throws Exception{
        //load dataset
        DataSource source = new DataSource("D:\\test1\\data.arff");
        Instances dataset = source.getDataSet();

        //use a simple filter to NominalToString a certain attribute
        //set up options to NominalToString 2nd attribute
        String[] opts = new String[]{ "-C", "2"};
        //create a NominalToString object (this is the filter class)
        NominalToString Nom2Str = new NominalToString();
        //set the filter options
        Nom2Str.setOptions(opts);
        //pass the dataset to the filter
        Nom2Str.setInputFormat(dataset);
        //apply the filter
        Instances newData = Filter.useFilter(dataset, Nom2Str);

        //saving filtered data as new arff dataset file
        ArffSaver saver = new ArffSaver();
        saver.setInstances(newData);
        saver.setFile(new File("D:\\test1\\data2.arff"));
        saver.writeBatch();
/*
        //loading previously saved filtered file
        DataSource source1 = new DataSource("E:\\PROJECT\\data\\datastringed.arff");
        Instances dataset1 = source1.getDataSet();

         String[] opts1 = new String[3];
        //Applying StringToWordVector on the 2nd attribute
        //Enabling outputWordCounts and selecting NGramTokenizer with ‘max’ and ‘min’ set to 3 each
        opts1[0] = "-C";
        opts1[1] = "-tokenizer"; opts1[2] = "weka.core.tokenizers.NGramTokenizer -max 3 -min 3 -delimiters .,;:'()?!";

        StringToWordVector filter = new StringToWordVector();

        filter.setOptions(opts1);
     
        filter.setInputFormat(dataset1);
       
        Instances newData1 = Filter.useFilter(dataset1,filter);

        //saving filtered data as new arff dataset file
        ArffSaver saver1 = new ArffSaver();
        saver1.setInstances(newData1);
        saver1.setFile(new File("E:\\PROJECT\\data\\dataNgram3.arff"));
        saver1.writeBatch();

        //loading previously saved filtered file
        DataSource source2 = new DataSource("E:\\PROJECT\\data\\dataNgram3.arff");
        Instances dataset2 = source2.getDataSet();

        //use a simple filter to Reorder a certain, ‘Nature’ attribute
        //set up options to Reorder 2nd attribute to last
        String[] opts11 = new String[]{ "-R", "1,3-last,2"};
        //create a Reorder object (this is the filter class)
        Reorder reOrd = new Reorder();
        //set the filter options
        reOrd.setOptions(opts11);
        //pass the dataset to the filter
        reOrd.setInputFormat(dataset2);
        //apply the filter
        Instances newData11 = Filter.useFilter(dataset2, reOrd);

        //saving filtered data as new arff dataset file
        ArffSaver saver11 = new ArffSaver();
        saver11.setInstances(newData11);
        saver11.setFile(new File("E:\\PROJECT\\data\\dataReordered.arff"));
        saver11.writeBatch();
*/
    }
}
