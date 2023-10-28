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
      fury.register(Nil.getClass)
      fury.register(ScalaFuryUtils.ScalaColonColonClass)
      fury.register(ScalaFuryUtils.ScalaIterableToFactoryClass)
      fury.register(ScalaFuryUtils.ScalaList$Class)
      fury.register(ScalaFuryUtils.ScalaSerializeEnd$Class)
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
      fury.register(ScalaFuryUtils.ScalaColonColonClass)
      fury.register(ScalaFuryUtils.ScalaIterableToFactoryClass)
      fury.register(ScalaFuryUtils.ScalaList$Class)
      fury.register(ScalaFuryUtils.ScalaSerializeEnd$Class)
      fury.register(classOf[ListWrapper[_]])
      val listWrapper = ListWrapper(List.empty)
      val bytes = fury.serialize(listWrapper)
      fury.deserialize(bytes) shouldEqual listWrapper
    }
    "serialize/deserialize Option[Long]" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[Option[_]])
      fury.register(classOf[Some[_]])
      fury.register(None.getClass)
      fury.register(classOf[ModuleSerializationProxy])
      val opt: Option[Long] = Some(123)
      val bytes = fury.serialize(opt)
      fury.deserialize(bytes) shouldEqual opt
    }
    "serialize/deserialize None" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[Option[_]])
      fury.register(classOf[Some[_]])
      fury.register(None.getClass)
      fury.register(classOf[ModuleSerializationProxy])
      val opt: Option[Long] = None
      val bytes = fury.serialize(opt)
      fury.deserialize(bytes) shouldEqual opt
    }
    "serialize/deserialize Weekday" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(ScalaFuryUtils.ScalaEnumerationValClass)
      fury.register(classOf[ModuleSerializationProxy])
      fury.register(WeekDay.getClass)
      val bytes = fury.serialize(WeekDay.Wed)
      fury.deserialize(bytes) shouldBe WeekDay.Wed
    }
    "serialize/deserialize Line" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[Line])
      fury.register(classOf[Point])
      fury.register(classOf[Point2D])
      val line = Line(Point2D(1.234, 98.7), Point2D(-56.78, 0.0))
      val bytes = fury.serialize(line)
      fury.deserialize(bytes) shouldEqual line
    }
  }
}
