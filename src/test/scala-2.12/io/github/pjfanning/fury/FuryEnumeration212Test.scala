package io.github.pjfanning.fury

import io.fury.Fury
import io.fury.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FuryEnumeration212Test extends AnyWordSpec with Matchers {
  "fury scala object support" should {
    "serialize/deserialize Weekday" in {
      // https://github.com/alipay/fury/issues/1032
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(ScalaClasses.ScalaEnumerationValClass)
      fury.register(WeekDay.getClass)
      val bytes = fury.serialize(WeekDay.Wed)
      fury.deserialize(bytes) shouldBe WeekDay.Wed
    }
  }
}
