package io.github.pjfanning.fury

/**
 * Internal Scala classes that you may need to register when serializing with Fory
 */
object ScalaClasses {
  lazy val ScalaEnumerationValClass = Class.forName("scala.Enumeration$Val")
  lazy val ScalaColonColonClass = Class.forName("scala.collection.immutable.$colon$colon")
  lazy val ScalaList$Class = Class.forName("scala.collection.immutable.List$")
  lazy val ScalaSet2Class = Class.forName("scala.collection.immutable.Set$Set2")

  // scala 2.12 class (not in scala 2.13+)
  lazy val ScalaListSerializationProxyClass = Class.forName("scala.collection.immutable.List$SerializationProxy")
  lazy val ScalaListSerializeEnd$Class = Class.forName("scala.collection.immutable.ListSerializeEnd$")

  // scala 2.13+ classes
  lazy val ScalaIterableToFactoryClass = Class.forName("scala.collection.IterableFactory$ToFactory")
  lazy val ScalaSerializeEnd$Class = Class.forName("scala.collection.generic.SerializeEnd$")
}
