package mapping.sample

import io.scalaland.chimney.dsl._
import org.joda.time.DateTime


case class RootSourceObject(sourceName: String, sourceNestedItemList: Seq[SourceNestedItem])

case class SourceNestedItem(sourceNestedItemName: String, price: BigDecimal,
                            sourceSecondLevelNestedList: Seq[SourceSecondLevelNestedObject])

case class SourceSecondLevelNestedObject(sourceSecondLevelNestedItemName: String)

case class RootTargetObject(targetName: String, targetNestedItemList: Seq[TargetNestedItem])

case class TargetNestedItem(targetNestedItemName: String, price: BigDecimal, targetSecondLevelNestedList: Seq[TargetSecondLevelNestedObject])

case class TargetSecondLevelNestedObject(targetSecondLevelNestedItemName: String)


case class PersonDomain(name: String, age: Int)

case class EntityMetadata(lastUpdated: DateTime, creationTime: DateTime, createdBy: String, isDeleted: Boolean)

case class DatabaseEntity[A](entity: A, entityMetadata: EntityMetadata)


case class PersonContract(name: String, age: Int, lastUpdated: DateTime, creationTime: DateTime, createdBy: String)


object HelloWorld {
  def main(args: Array[String]): Unit = {

    import Mappers._


    val personDbEntity = DatabaseEntity[PersonDomain](PersonDomain("avi", 2), EntityMetadata(DateTime.now(), DateTime.now(), "admin", false))

    val personContractWithNoMetadata = personDbEntity.entity.into[PersonContract].transform

    val finalPersonContract = personContractWithNoMetadata.copy(lastUpdated = personDbEntity.entityMetadata.lastUpdated,
                                                                creationTime = personDbEntity.entityMetadata.creationTime,
                                                                createdBy = personDbEntity.entityMetadata.createdBy)

    println(finalPersonContract)
    
    val mappingResults = personDbEntity.into[PersonContract].transform
    println(mappingResults)

  }
}