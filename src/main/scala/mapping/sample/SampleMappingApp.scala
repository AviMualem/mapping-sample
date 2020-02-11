package mapping.sample

import io.scalaland.chimney.dsl._
//import TransformerInstances._
import org.joda.time.DateTime


case class RootSourceObject(sourceName: String, sourceNestedItemList: Seq[SourceNestedItem])

case class SourceNestedItem(sourceNestedItemName: String, price: BigDecimal,
                            sourceSecondLevelNestedList: Seq[SourceSecondLevelNestedObject])

case class SourceSecondLevelNestedObject(sourceSecondLevelNestedItemName: String)

case class RootTargetObject(targetName: String, targetNestedItemList: Seq[TargetNestedItem])

case class TargetNestedItem(targetNestedItemName: String, price: BigDecimal, targetSecondLevelNestedList: Seq[TargetSecondLevelNestedObject])

case class TargetSecondLevelNestedObject(targetSecondLevelNestedItemName: String)


case class Person(name: String, age: Int)

case class EntityMetadata(lastUpdated: DateTime, creationTime: DateTime, createdBy: String, isDeleted: Boolean)

case class DatabaseEntity[A](entity: A, entityMetadata: EntityMetadata)


case class PersonContract(name: String, age: Int, lastUpdated: DateTime, creationTime: DateTime, createdBy: String)


object HelloWorld {
  def main(args: Array[String]): Unit = {

    import Mappers._

    val personDbEntity = DatabaseEntity[Person](Person("avi", 2), EntityMetadata(DateTime.now(), DateTime.now(), "admin", false))

    val mappingResults = personDbEntity.into[PersonContract].transform

    //
    //
    //   case class Source(data: String, number: Int, sourceField1: String, someNumber:Int)
    //   case class Target(data: String, number: Int, targetField1: String, calculatedValue:Int)

    //   implicit val mapper = Transformer.define[Source, Target]
    //                        .withFieldRenamed(_.sourceField1, _.targetField1)
    //                        .withFieldComputed(_.calculatedValue,_.someNumber + 10)
    //                        .buildTransformer
    //
    //    val sourceInstance = Source("data", 1, "source-field-value",1)
    //    val target = sourceInstance.into[Target].transform
    //    println(target)
    //
    //    import Mappers._
    //    val sourceObjectInstance = RootSourceObject("src-name", List(SourceNestedItem("nested-name", 22,
    //      List(SourceSecondLevelNestedObject("2name")))))
    //
    //
    //
    //
    //
    //    /**
    //      * i would expect this will work due the the fact that all mapping definitions for root and nested object are provided via
    //      * implicit variables.
    //      */
    //
    //    val mappedResult = sourceObjectInstance.into[RootTargetObject].transform
    //
    //    val x = 2

  }
}