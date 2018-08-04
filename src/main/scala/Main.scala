import org.apache.spark.sql.SparkSession

object Main {

  def main(args: Array[String]): Unit = {



    val spark = SparkSession.builder().master("local").appName("spark_unit_testing").getOrCreate()

    val data = Array(1, 2, 3, 4, 5)
    val distData = spark.sparkContext.parallelize(data)


    import spark.implicits._
    val df = distData.toDF()


    val t =SimpleTransformation.aggTotal(df)

    t.show(1);
  }




}
