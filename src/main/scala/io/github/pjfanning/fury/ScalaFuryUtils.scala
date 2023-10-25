package io.github.pjfanning.fury

object ScalaFuryUtils {
  lazy val ScalaEnumerationValClass = Class.forName("scala.Enumeration$Val")
  lazy val ScalaColonColonClass = Class.forName("scala.collection.immutable.$colon$colon")
  lazy val ScalaIterableToFactoryClass = Class.forName("scala.collection.IterableFactory$ToFactory")
  lazy val ScalaList$Class = Class.forName("scala.collection.immutable.List$")
  lazy val ScalaSerializeEnd$Class = Class.forName("scala.collection.generic.SerializeEnd$")
}
