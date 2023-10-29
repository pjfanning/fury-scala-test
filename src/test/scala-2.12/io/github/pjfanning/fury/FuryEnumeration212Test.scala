package io.github.pjfanning.fury

import io.fury.Fury
import io.fury.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.mutable

class FuryEnumeration212Test extends AnyWordSpec with Matchers {
  "fury scala enumeration support" should {
    "serialize/deserialize Weekday" in {
      // withRefTracking(true) is needed or a StackOverflowError will happen
      // https://github.com/alipay/fury/issues/1032
      val fury = Fury.builder().withLanguage(Language.JAVA).withRefTracking(true).build()
      fury.register(ScalaClasses.ScalaEnumerationValClass)
      fury.register(classOf[mutable.HashMap[_, _]])
      fury.register(WeekDay.getClass)
      val bytes = fury.serialize(WeekDay.Wed)
      fury.deserialize(bytes) shouldBe WeekDay.Wed
    }
  }
}
