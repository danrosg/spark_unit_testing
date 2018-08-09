import org.apache.spark.sql.SparkSession
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, FunSuite}

class SimpleTransformationTest  extends FunSuite with
  BeforeAndAfterEach with BeforeAndAfterAll {


  @transient var spark: SparkSession = null


  override def beforeAll(): Unit = {

    spark= SparkSession.builder().master("local[*]").appName("spark_unit_testing_tests").enableHiveSupport().getOrCreate()

  }


  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }

  test("Invoking head on an empty Set should produce NoSuchElementException") {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }

  test("Spark Simple Function Test" ) {

      val data = Array(1, 21, 3, 4, 5)
      val distData = spark.sparkContext.parallelize(data)

      val sc = spark
      import sc.implicits._

      val df = distData.toDF()

      val agg = SimpleTransformation.aggTotal(df).take(1)

      assert(agg(0)(0)==34,"The sum should be 15")


  }






}
