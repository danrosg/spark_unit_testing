import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col



object SimpleTransformation {


    //Schema dependant transfomation

  def aggTotal(dataFrame: DataFrame)={


    dataFrame.createOrReplaceTempView("table")
    dataFrame.sparkSession.sql("SELECT sum(value) as value FROM table")

  }

  // Schema independant transformation

  def combineColumns(str1:String, str2:String, target:String)(dataFrame: DataFrame) ={

    dataFrame.withColumn(target,col(str1)+col(str2))

  }


}
