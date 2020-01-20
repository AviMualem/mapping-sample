package mapping.sample

import io.scalaland.chimney.Transformer

object TransformerInstances {
  implicit val rootObjectTransformer: Transformer[RootSourceObject, RootTargetObject] = TransformerDefinitions.rootObjectTransformer
  implicit val nestedItemTransformer: Transformer[SourceNestedItem, TargetNestedItem] = TransformerDefinitions.nestedItemTransformer
}
