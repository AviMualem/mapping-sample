package mapping.sample
import io.scalaland.chimney.dsl._
//import TransformerInstances._


case class RootSourceObject(sourceName: String, sourceNestedItemList: Seq[SourceNestedItem])

case class SourceNestedItem(sourceNestedItemName: String, price: BigDecimal,
                            sourceSecondLevelNestedList:Seq[SourceSecondLevelNestedObject])

case class SourceSecondLevelNestedObject(sourceSecondLevelNestedItemName:String)

case class RootTargetObject(targetName: String, targetNestedItemList: Seq[TargetNestedItem])

case class TargetNestedItem(targetNestedItemName: String, price: BigDecimal, targetSecondLevelNestedList:Seq[TargetSecondLevelNestedObject])

case class TargetSecondLevelNestedObject(targetSecondLevelNestedItemName:String)




object HelloWorld {
  def main(args: Array[String]): Unit = {

    import Mappers._



    val sourceObjectInstance = RootSourceObject("src-name",List(SourceNestedItem("nested-name",22,
      List(SourceSecondLevelNestedObject("2name")))))

    /**
      * i would expect this will work due the the fact that all mapping definitions for root and nested object are provided via
      * implicit variables.
       */


    val mappedResult = sourceObjectInstance.into[RootTargetObject].transform

    val x=2

  }
}