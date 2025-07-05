package io.github.pjfanning.fury

import org.apache.fory.Fory
import org.apache.fory.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.runtime.ModuleSerializationProxy

class FuryEnumeration213Test extends AnyWordSpec with Matchers {
  "fury scala enumeration support" should {
    "serialize/deserialize Weekday" in {
      val fury = Fory.builder().withLanguage(Language.JAVA).build()
      fury.register(ScalaClasses.ScalaEnumerationValClass)
      fury.register(classOf[ModuleSerializationProxy])
      fury.register(WeekDay.getClass)
      val bytes = fury.serialize(WeekDay.Wed)
      fury.deserialize(bytes) shouldBe WeekDay.Wed
    }
  }
}
