import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row

case class Person(name: String, age: Long)


object Main {

  def main(args: Array[String]): Unit = {



    val spark = SparkSession.builder().master("local")
                                    .appName("spark_unit_testing")
                                    .enableHiveSupport()
                                    .getOrCreate()

    val data = Array(1, 2, 3, 4, 5)
    val distData = spark.sparkContext.parallelize(data)


    import spark.implicits._
    val df = distData.toDF()


    val t =SimpleTransformation.aggTotal(df)

    t.show(1);


    val caseClassDS = Seq(Person("Andy", 32)).toDF()
    caseClassDS.printSchema()


    val primitiveDS = Seq(1, 2, 3).toDS()
    primitiveDS.map(_ + 1).collect() // Returns: Array(2, 3, 4)




    val basicRDD =spark.sparkContext.parallelize( Seq ( Row("one", "two"),
                                                        Row("three","four"),
                                                        Row("five","six")))


    spark.sql("CREATE TABLE IF NOT EXISTS src (col1 STRING, col2  STRING) using hive")

    val emptyDF= spark.sql("SELECT * FROM src limit 0")

    emptyDF.printSchema()

    //val fillDF = spark.createDataFrame(basicRDD,emptyDF.schema)


   // fillDF.show(10)


  }




}
