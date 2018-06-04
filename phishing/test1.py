from pyspark import SparkContext
from pyspark import SparkConf
from pyspark.sql import SQLContext

conf = SparkConf()
sc = SparkContext(conf = conf)

print ("My first example.")
sqlContext = SQLContext(sc)
csv_default = sqlContext.read.csv("animals.csv", header=True)
csv_default.show()
csv_default.write.csv("Contacts1.csv", header=True)
print ("example finished.")
sc.close()