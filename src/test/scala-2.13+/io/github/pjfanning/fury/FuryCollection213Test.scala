package io.github.pjfanning.fury

import io.fury.Fury
import io.fury.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.generic.DefaultSerializationProxy
import scala.runtime.ModuleSerializationProxy

class FuryCollection213Test extends AnyWordSpec with Matchers {
  "fury scala collection support" should {
    "serialize/deserialize ListWrapper" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[DefaultSerializationProxy[_]])
      fury.register(classOf[ModuleSerializationProxy])
      fury.register(Nil.getClass)
      fury.register(ScalaClasses.ScalaColonColonClass)
      fury.register(ScalaClasses.ScalaIterableToFactoryClass)
      fury.register(ScalaClasses.ScalaList$Class)
      fury.register(ScalaClasses.ScalaSerializeEnd$Class)
      fury.register(classOf[ListWrapper[_]])
      val listWrapper = ListWrapper(List(1234567890L, 9876543210L))
      val bytes = fury.serialize(listWrapper)
      fury.deserialize(bytes) shouldEqual listWrapper
    }
    "serialize/deserialize ListWrapper with empty list" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[DefaultSerializationProxy[_]])
      fury.register(classOf[ModuleSerializationProxy])
      fury.register(Nil.getClass)
      fury.register(ScalaClasses.ScalaColonColonClass)
      fury.register(ScalaClasses.ScalaIterableToFactoryClass)
      fury.register(ScalaClasses.ScalaList$Class)
      fury.register(ScalaClasses.ScalaSerializeEnd$Class)
      fury.register(classOf[ListWrapper[_]])
      val listWrapper = ListWrapper(List.empty)
      val bytes = fury.serialize(listWrapper)
      fury.deserialize(bytes) shouldEqual listWrapper
    }
  }
}
