package mapping.sample

import io.scalaland.chimney.Transformer
import io.scalaland.chimney.dsl._

object TransformerDefinitions {

  val nestedItemTransformer: Transformer[SourceNestedItem, TargetNestedItem] = {
    _.into[TargetNestedItem]
      .withFieldRenamed(_.sourceNestedItemName, _.targetNestedItemName)
      .transform
  }

  val rootObjectTransformer: Transformer[RootSourceObject, RootTargetObject] = {
    _.into[RootTargetObject]
      .withFieldRenamed(_.sourceName, _.targetName)
      .withFieldRenamed(_.sourceNestedItemList, _.targetNestedItemList)
      .transform
  }
}
