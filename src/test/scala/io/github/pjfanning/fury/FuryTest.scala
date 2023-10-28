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
