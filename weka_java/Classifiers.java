package weka.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.rules.JRip;
import weka.classifiers.rules.OneR;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.DecisionStump;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

public class CLASSSIFIRE{

static String DecisionStumpModelPath = "E:\\PROJECT\\models\\decisionstump.model";
static String J48ModelPath = " E:\\PROJECT\\models\\J48.model";
static String JRIPModelPath = " E:\\PROJECT\\models\\jrip.model";
static String NaiveBayesModelPath = " E:\\PROJECT\\models\\naiveBayes.model";
static String OneRModelPath = " E:\\PROJECT\\models\\oneR.model";
static String PARTModelPath = " E:\\PROJECT\\models\\part.model";
static String RandomForestModelPath = " E:\\PROJECT\\models\\ randomForest.model";
static String SMOModelPath = " E:\\PROJECT\\models\\SMO.model";

void decisionStump() throws Exception{

double percent = 90.0; 
BufferedReader breader;
breader =new BufferedReader (new FileReader("E:\\PROJECT\\data\\dataordered.arff"));
Instances inst = new Instances(breader);

inst.setClassIndex(inst.numAttributes() - 1); 
//set the last column as the class attribute 
//PARAMETERS are set 

DecisionStump deciStumptree = new DecisionStump();
int seed=1;
Random rnd = new Random(seed);
inst.randomize(rnd);

String[] options;

options = weka.core.Utils.splitOptions("");
deciStumptree.setOptions(options);

System.out.println("Performing " +percent+" %split evaluation");

int trainSize = (int) Math.round(inst.numInstances()*percent/100);

int testSize = inst.numInstances()-trainSize;

Instances train = new Instances (inst, 0, trainSize);
Instances test = new Instances (inst, trainSize,testSize);

deciStumptree.buildClassifier(train);

Evaluation eval = new Evaluation(train );
eval.evaluateModel(deciStumptree, test); 

breader.close();

System.out.println(eval.toSummaryString("\nResults\n======\n", false)); 

System.out.println("training performance results of: " + deciStumptree.getClass().getSimpleName() 
+ "\n---------------------------------");
System.out.println(eval.toSummaryString("\nResults",true));
System.out.println("fmeasure: " +eval.fMeasure(1) + " Precision: " + eval.precision(1)+ " Recall: "+ eval.recall(1));
System.out.println(eval.toMatrixString());
System.out.println(eval.toClassDetailsString());
System.out.println("AUC = " +eval.areaUnderROC(1));
System.out.println("Training complete, please validate trained model");
}

void j48() throws Exception{

double percent = 90.0; 
BufferedReader breader;
breader =new BufferedReader (new FileReader("E:\\PROJECT\\data\\dataordered.arff"));
Instances inst = new Instances(breader);

inst.setClassIndex(inst.numAttributes() - 1);
//set the last column as the class attribute 
///PARAMETERS are set 

J48 J4tree = new J48();
int seed=1;
Random rnd = new Random(seed);
inst.randomize(rnd);

String[] options;

options = weka.core.Utils.splitOptions("-C 0.25 -M 2");
J4tree.setOptions(options);

System.out.println("Performing " +percent +"%split evaluation");

int trainSize = (int) Math.round(inst.numInstances()*percent/100);

int testSize = inst.numInstances()-trainSize;

Instances train = new Instances (inst, 0, trainSize);
Instances test = new Instances (inst, trainSize,testSize);

J4tree.buildClassifier(train);

Evaluation eval = new Evaluation(train );
eval.evaluateModel(J4tree, test); 

breader.close();

System.out.println(eval.toSummaryString("\nResults\n======\n", false)); 

System.out.println("training performance results of: " + J4tree.getClass().getSimpleName() 
+ "\n---------------------------------");
System.out.println(eval.toSummaryString("\nResults",true));
System.out.println("fmeasure: " +eval.fMeasure(1) + " Precision: " + eval.precision(1)+ " Recall: "+ eval.recall(1));
System.out.println(eval.toMatrixString());
System.out.println(eval.toClassDetailsString());
System.out.println("AUC = " +eval.areaUnderROC(1));
System.out.println("Training complete, please validate trained model");
}
	
void jrip() throws Exception{

double percent = 90.0; 
BufferedReader breader;
breader =new BufferedReader (new FileReader("E:\\PROJECT\\data\\dataordered.arff"));
Instances inst = new Instances(breader);

inst.setClassIndex(inst.numAttributes() - 1); 
//set the last column as the class attribute 
//PARAMETERS are set 

JRip jayRip = new JRip();
int seed=1;
Random rnd = new Random(seed);
inst.randomize(rnd);

String[] options;

options = weka.core.Utils.splitOptions("-F 3 -N 2.0 -O 2 -S 1");
jayRip.setOptions(options);

System.out.println("Performing " +percent+" %split evaluation");

int trainSize = (int) Math.round(inst.numInstances()*percent/100);

int testSize = inst.numInstances()-trainSize;

Instances train = new Instances (inst, 0, trainSize);
Instances test = new Instances (inst, trainSize,testSize);

jayRip.buildClassifier(train);

Evaluation eval = new Evaluation(train );
eval.evaluateModel(jayRip, test); 

breader.close();

System.out.println(eval.toSummaryString("\nResults\n======\n", false)); 

System.out.println("training performance results of: " + jayRip.getClass().getSimpleName() 
+ "\n---------------------------------");
System.out.println(eval.toSummaryString("\nResults",true));
System.out.println("fmeasure: " +eval.fMeasure(1) + " Precision: " + eval.precision(1)+ " Recall: "+ eval.recall(1));
System.out.println(eval.toMatrixString());
System.out.println(eval.toClassDetailsString());
System.out.println("AUC = " +eval.areaUnderROC(1));
System.out.println("Training complete, please validate trained model");
}

void naiveBayes() throws Exception{

double percent = 90.0; 
BufferedReader breader;
breader =new BufferedReader (new FileReader("E:\\PROJECT\\data\\dataordered.arff"));
Instances inst = new Instances(breader);

inst.setClassIndex(inst.numAttributes() - 1); 
//set the last column as the class attribute 
//PARAMETERS are set 

NaiveBayes NBays = new NaiveBayes();
int seed=1;
Random rnd = new Random(seed);
inst.randomize(rnd);

String[] options;

options = weka.core.Utils.splitOptions("");
NBays.setOptions(options);

System.out.println("Performing " +percent+" %split evaluation");

int trainSize = (int) Math.round(inst.numInstances()*percent/100);

int testSize = inst.numInstances()-trainSize;

Instances train = new Instances (inst, 0, trainSize);
Instances test = new Instances (inst, trainSize,testSize);

NBays.buildClassifier(train);

Evaluation eval = new Evaluation(train );
eval.evaluateModel(NBays, test); 

breader.close();

System.out.println(eval.toSummaryString("\nResults\n======\n", false)); 

System.out.println("training performance results of: " + NBays.getClass().getSimpleName() 
+ "\n---------------------------------");
System.out.println(eval.toSummaryString("\nResults",true));
System.out.println("fmeasure: " +eval.fMeasure(1) + " Precision: " + eval.precision(1)+ " Recall: "+ eval.recall(1));
System.out.println(eval.toMatrixString());
System.out.println(eval.toClassDetailsString());
System.out.println("AUC = " +eval.areaUnderROC(1));
System.out.println("Training complete, please validate trained model");
}

void oneR() throws Exception{

double percent = 90.0; 
BufferedReader breader;
breader =new BufferedReader (new FileReader("E:\\PROJECT\\data\\dataordered.arff"));
Instances inst = new Instances(breader);

inst.setClassIndex(inst.numAttributes() - 1); 
//set the last column as the class attribute 
//PARAMETERS are set 

OneR wunaaR = new OneR();
int seed=1;
Random rnd = new Random(seed);
inst.randomize(rnd);

String[] options;

options = weka.core.Utils.splitOptions("-B 6");
wunaaR.setOptions(options);

System.out.println("Performing " +percent+" %split evaluation");

int trainSize = (int) Math.round(inst.numInstances()*percent/100);

int testSize = inst.numInstances()-trainSize;

Instances train = new Instances (inst, 0, trainSize);
Instances test = new Instances (inst, trainSize,testSize);

wunaaR.buildClassifier(train);

Evaluation eval = new Evaluation(train );
eval.evaluateModel(wunaaR, test); 

breader.close();

System.out.println(eval.toSummaryString("\nResults\n======\n", false)); 

System.out.println("training performance results of: " + wunaaR.getClass().getSimpleName() 
+ "\n---------------------------------");
System.out.println(eval.toSummaryString("\nResults",true));
System.out.println("fmeasure: " +eval.fMeasure(1) + " Precision: " + eval.precision(1)+ " Recall: "+ eval.recall(1));
System.out.println(eval.toMatrixString());
System.out.println(eval.toClassDetailsString());
System.out.println("AUC = " +eval.areaUnderROC(1));
System.out.println("Training complete, please validate trained model");
}

void part() throws Exception{

double percent = 90.0; 
BufferedReader breader;
breader =new BufferedReader (new FileReader("E:\\PROJECT\\data\\dataordered.arff"));
Instances inst = new Instances(breader);

inst.setClassIndex(inst.numAttributes() - 1); 
//set the last column as the class attribute 
//PARAMETERS are set 

PART par8 = new PART();
int seed=1;
Random rnd = new Random(seed);
inst.randomize(rnd);

String[] options;

options = weka.core.Utils.splitOptions("-M 2 -C 0.25 -Q 1");
par8.setOptions(options);

System.out.println("Performing " +percent+" %split evaluation");

int trainSize = (int) Math.round(inst.numInstances()*percent/100);

int testSize = inst.numInstances()-trainSize;

Instances train = new Instances (inst, 0, trainSize);
Instances test = new Instances (inst, trainSize,testSize);

par8.buildClassifier(train);

Evaluation eval = new Evaluation(train );
eval.evaluateModel(par8, test); 

breader.close();

System.out.println(eval.toSummaryString("\nResults\n======\n", false)); 

System.out.println("training performance results of: " + par8.getClass().getSimpleName() 
+ "\n---------------------------------");
System.out.println(eval.toSummaryString("\nResults",true));
System.out.println("fmeasure: " +eval.fMeasure(1) + " Precision: " + eval.precision(1)+ " Recall: "+ eval.recall(1));
System.out.println(eval.toMatrixString());
System.out.println(eval.toClassDetailsString());
System.out.println("AUC = " +eval.areaUnderROC(1));
System.out.println("Training complete, please validate trained model");
}

void randomForest() throws Exception{

double percent = 90.0; 
BufferedReader breader;
breader =new BufferedReader (new FileReader("E:\\PROJECT\\data\\dataordered.arff"));
Instances inst = new Instances(breader);

inst.setClassIndex(inst.numAttributes() - 1); 
//set the last column as the class attribute 
//PARAMETERS are set 

RandomForest randomfortree = new RandomForest();
int seed=1;
Random rnd = new Random(seed);
inst.randomize(rnd);

String[] options;

options = weka.core.Utils.splitOptions("-P 100 -I 100 -num-slots 1 -K 0 -M 1.0 -V 0.001 -S 1");
randomfortree.setOptions(options);

System.out.println("Performing " +percent+" %split evaluation");

int trainSize = (int) Math.round(inst.numInstances()*percent/100);

int testSize = inst.numInstances()-trainSize;

Instances train = new Instances (inst, 0, trainSize);
Instances test = new Instances (inst, trainSize,testSize);

randomfortree.buildClassifier(train);

Evaluation eval = new Evaluation(train );
eval.evaluateModel(randomfortree, test); 

breader.close();

System.out.println(eval.toSummaryString("\nResults\n======\n", false)); 

System.out.println("training performance results of: " + randomfortree.getClass().getSimpleName() 
+ "\n---------------------------------");
System.out.println(eval.toSummaryString("\nResults",true));
System.out.println("fmeasure: " +eval.fMeasure(1) + " Precision: " + eval.precision(1)+ " Recall: "+ eval.recall(1));
System.out.println(eval.toMatrixString());
System.out.println(eval.toClassDetailsString());
System.out.println("AUC = " +eval.areaUnderROC(1));
System.out.println("Training complete, please validate trained model");
}

void smo() throws Exception{

double percent = 90.0; 
BufferedReader breader;
breader =new BufferedReader (new FileReader("E:\\PROJECT\\data\\dataordered.arff"));
Instances inst = new Instances(breader);

inst.setClassIndex(inst.numAttributes() - 1); 
//set the last column as the class attribute 
//PARAMETERS are set 

SMO esemOH = new SMO();
int seed=1;
Random rnd = new Random(seed);
inst.randomize(rnd);

String[] options;

options = weka.core.Utils.splitOptions("-C 1.0 -L 0.001 -P 1.0E-12 -N 0 -V -1 -W 1 -K \"weka.classifiers.functions.supportVector.PolyKernel -E 1.0 -C 250007\" -calibrator \"weka.classifiers.functions.Logistic -R 1.0E-8 -M -1 -num-decimal-places 4\"");
esemOH.setOptions(options);

System.out.println("Performing " +percent+" %split evaluation");

int trainSize = (int) Math.round(inst.numInstances()*percent/100);

int testSize = inst.numInstances()-trainSize;

Instances train = new Instances (inst, 0, trainSize);
Instances test = new Instances (inst, trainSize,testSize);

esemOH.buildClassifier(train);

Evaluation eval = new Evaluation(train );
eval.evaluateModel(esemOH, test); 

breader.close();

System.out.println(eval.toSummaryString("\nResults\n======\n", false)); 

System.out.println("training performance results of: " + esemOH.getClass().getSimpleName() 
+ "\n---------------------------------");
System.out.println(eval.toSummaryString("\nResults",true));
System.out.println("fmeasure: " +eval.fMeasure(1) + " Precision: " + eval.precision(1)+ " Recall: "+ eval.recall(1));
System.out.println(eval.toMatrixString());
System.out.println(eval.toClassDetailsString());
System.out.println("AUC = " +eval.areaUnderROC(1));
System.out.println("Training complete, please validate trained model");
}
}
public class CHooser extends CLASSSIFIRE{
	public void display_menu()  {
	System.out.println("Choose one of the following classifiers...\n");
	System.out.println("1) Decision Stump\n2) J48\n3) JRIP\n4) Naive Bayes\n5)ONE R\n6) PART\n7) Random Forest\n8) SMO\n");
	System.out.print("Selection: ");
    }
    public void question() throws Exception  {
	System.out.println("Would you like to proceed or quit?");
	System.out.println("To proceed enter 9.");
	System.out.println("If you wish to quit enter 0.");
	Scanner q = new Scanner(System.in);
       
	switch (q.nextInt()) {
	    case 0:
	    System.out.println ("process terminated...");
	    break;
  
	    case 9:
	    System.out.println ("Make selection...");
	    new CHooser();
	    break;
	    default:
	    System.err.println ( "Unrecognized option" );
	    break;
	}
	}
    public CHooser() throws Exception  {
	Scanner in = new Scanner(System.in);
        display_menu();
  
	switch (in.nextInt())  {
	    case 1:
	    System.out.println ( "You picked option Decision Stump" );
	    decisionStump();
	    question();
	    break;
  
	    case 2:
	    System.out.println ( "You picked option j48" );
	    j48();
	    question();
	    break;
  
	    case 3:
	    System.out.println ( "You picked option JRIP" );
	    jrip();
	    question();
	    break;

	    case 4:
	    System.out.println ( "You picked option Naive Bayes" );
	    naiveBayes();
	    question();
	    break;

	    case 5:
	    System.out.println ( "You picked option OneR" );
	    oneR();
	    question();
	    break;

	    case 6:
	    System.out.println ( "You picked option PART" );
	    part();
	    question();
	    break;

	    case 7:
	    System.out.println ( "You picked option Random Forest" );
	    randomForest();
	    question();
	    break;

	    case 8:
	    System.out.println ( "You picked option SMO" );
	    smo();
	    question();
	    break;

	    default:
	    System.err.println ( "Unrecognized option" );
	    break;
	}
    }
     public static void main (String[] args) throws Exception   {
	new CHooser();
    }
}
