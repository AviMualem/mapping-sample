package mapping.sample

import io.scalaland.chimney.Transformer


object Mappers {

  implicit val personDbEntityMapper = Transformer.define[DatabaseEntity[PersonDomain], PersonContract]
    .withFieldComputed(_.createdBy, _.entityMetadata.createdBy)
    .withFieldComputed(_.lastUpdated, _.entityMetadata.lastUpdated)
    .withFieldComputed(_.creationTime, _.entityMetadata.creationTime)
    .withFieldComputed(_.name, _.entity.name)
    .withFieldComputed(_.age, _.entity.age)
    .buildTransformer

  implicit val personDomainToContractMapper = Transformer.define[PersonDomain, PersonContract]
    .withFieldConst(_.lastUpdated, null)
    .withFieldConst(_.creationTime, null)
    .withFieldConst(_.createdBy,null)
    .buildTransformer


  implicit val secondLevelNestedObjectTransformer =
    Transformer.define[SourceSecondLevelNestedObject, TargetSecondLevelNestedObject]
      .withFieldRenamed(_.sourceSecondLevelNestedItemName, _.targetSecondLevelNestedItemName)
      .buildTransformer

  implicit val nestedItemTransformer =
    Transformer.define[SourceNestedItem, TargetNestedItem]
      .withFieldRenamed(_.sourceNestedItemName, _.targetNestedItemName)
      .withFieldRenamed(_.sourceSecondLevelNestedList, _.targetSecondLevelNestedList)

      .buildTransformer

  //  implicit val rootObjectTransformer =
  //    Transformer.define[RootSourceObject, RootTargetObject]
  //      .withFieldRenamed(_.sourceName, _.targetName)
  //      .withFieldRenamed(_.sourceNestedItemList, _.targetNestedItemList)
  //      .buildTransformer
}
