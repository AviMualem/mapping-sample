package mapping.sample

import io.scalaland.chimney.Transformer
//import mapping.sample.TransformerDefinitions.secondLevelNestedObjectTransformer

//object TransformerDefinitions {
//
//  val secondLevelNestedObjectTransformer : Transformer[SourceSecondLevelNestedObject, TargetSecondLevelNestedObject]={
//      _.into[TargetSecondLevelNestedObject]
//      .withFieldRenamed(_.sourceSecondLevelNestedItemName,_.targetSecondLevelNestedItemName)
//      .transform
//  }
//
//  val nestedItemTransformer: Transformer[SourceNestedItem, TargetNestedItem] = {
//
//    implicit val v = secondLevelNestedObjectTransformer
//    _.into[TargetNestedItem]
//      .withFieldRenamed(_.sourceNestedItemName, _.targetNestedItemName)
//      .withFieldRenamed(_.sourceSecondLevelNestedList,_.targetSecondLevelNestedList)
//      .transform
//  }
//
//
//  val rootObjectTransformer: Transformer[RootSourceObject, RootTargetObject] = {
//     implicit val justForImport = nestedItemTransformer
//
//    _.into[RootTargetObject]
//      .withFieldRenamed(_.sourceName, _.targetName)
//      .withFieldRenamed(_.sourceNestedItemList, _.targetNestedItemList)
//      .transform
//  }
//}


object Mappers {

  implicit val secondLevelNestedObjectTransformer =
    Transformer.define[SourceSecondLevelNestedObject, TargetSecondLevelNestedObject]
      .withFieldRenamed(_.sourceSecondLevelNestedItemName, _.targetSecondLevelNestedItemName)
      .buildTransformer

  implicit val nestedItemTransformer =

    Transformer.define[SourceNestedItem, TargetNestedItem]
      .withFieldRenamed(_.sourceNestedItemName, _.targetNestedItemName)
      .withFieldRenamed(_.sourceSecondLevelNestedList, _.targetSecondLevelNestedList)
      .buildTransformer

  implicit val rootObjectTransformer =
    Transformer.define[RootSourceObject, RootTargetObject]
      .withFieldRenamed(_.sourceName, _.targetName)
      .withFieldRenamed(_.sourceNestedItemList, _.targetNestedItemList)
      .buildTransformer
}
