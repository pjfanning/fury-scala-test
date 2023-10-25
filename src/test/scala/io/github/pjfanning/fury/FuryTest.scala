package io.github.pjfanning.fury

import io.fury.Fury
import io.fury.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.generic.DefaultSerializationProxy
import scala.runtime.ModuleSerializationProxy

class FuryTest extends AnyWordSpec with Matchers {
  "fury" should {
    "serialize/deserialize Person" in {
      val person = Person("Cú Chulainn", 35, 1234567890)
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[Person])
      val bytes = fury.serialize(person)
      fury.deserialize(bytes) shouldEqual person
    }
    "serialize/deserialize SampleObject" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[ModuleSerializationProxy])
      fury.register(SampleObject.getClass)
      val bytes = fury.serialize(SampleObject)
      fury.deserialize(bytes) shouldBe SampleObject
    }
    "serialize/deserialize ListWrapper" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[DefaultSerializationProxy[_]])
      fury.register(classOf[ModuleSerializationProxy])
      fury.register(ScalaFuryUtils.ScalaColonColonClass)
      fury.register(ScalaFuryUtils.ScalaIterableToFactoryClass)
      fury.register(ScalaFuryUtils.ScalaList$Class)
      fury.register(ScalaFuryUtils.ScalaSerializeEnd$Class)
      fury.register(classOf[ListWrapper[_]])
      val listWrapper = ListWrapper(List(1234567890L, 9876543210L))
      val bytes = fury.serialize(listWrapper)
      fury.deserialize(bytes) shouldEqual listWrapper
    }
    "serialize/deserialize Weekday" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(ScalaFuryUtils.ScalaEnumerationValClass)
      fury.register(classOf[ModuleSerializationProxy])
      fury.register(WeekDay.getClass)
      val bytes = fury.serialize(WeekDay.Wed)
      fury.deserialize(bytes) shouldBe WeekDay.Wed
    }
  }
}
