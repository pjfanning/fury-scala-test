package io.github.pjfanning.fury

import io.fury.Fury
import io.fury.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FuryObject212Test extends AnyWordSpec with Matchers {
  "fury scala object support" should {
    "serialize/deserialize SampleObject" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(SampleObject.getClass)
      val bytes = fury.serialize(SampleObject)
      fury.deserialize(bytes) shouldBe SampleObject
    }
  }
}
