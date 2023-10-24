package io.github.pjfanning.fury

import io.fury.Fury
import io.fury.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

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
      fury.register(SampleObject.getClass)
      val bytes = fury.serialize(SampleObject)
      fury.deserialize(bytes) shouldBe SampleObject
    }
  }
}
