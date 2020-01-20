package mapping.sample
import io.scalaland.chimney.dsl._


case class RootSourceObject(sourceName: String, sourceNestedItemList: Seq[SourceNestedItem])

case class SourceNestedItem(sourceNestedItemName: String, price: BigDecimal)

case class RootTargetObject(targetName: String, targetNestedItemList: Seq[TargetNestedItem])

case class TargetNestedItem(targetNestedItemName: String, price: BigDecimal)




object HelloWorld {
  def main(args: Array[String]): Unit = {

    import TransformerInstances._

    val sourceObjectInstance = RootSourceObject("src-name",List(SourceNestedItem("nested-name",22)))

    /**
      * i would expect this will work due the the fact that all mapping definitions for root and nested object are provided via
      * implicit variables.
       */
    val mappedResult = sourceObjectInstance.into[RootTargetObject].transform

  }
}