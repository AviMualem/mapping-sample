package mapping.sample

import io.scalaland.chimney.Transformer

object TransformerInstances {
  implicit val nestedItemTransformer: Transformer[SourceNestedItem, TargetNestedItem] = TransformerDefinitions.nestedItemTransformer
  implicit val rootObjectTransformer: Transformer[RootSourceObject, RootTargetObject] = TransformerDefinitions.rootObjectTransformer
  implicit val secondLevelNestedObject :Transformer[SourceSecondLevelNestedObject, TargetSecondLevelNestedObject] = TransformerDefinitions.secondLevelNestedObjectTransformer
}
