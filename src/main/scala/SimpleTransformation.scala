import org.apache.spark.sql.DataFrame


object SimpleTransformation {

  def aggTotal(dataFrame: DataFrame)={

    //dataFrame.printSchema()
    dataFrame.createOrReplaceTempView("table")
    dataFrame.sparkSession.sql("SELECT sum(value) as value FROM table")

  }


}
