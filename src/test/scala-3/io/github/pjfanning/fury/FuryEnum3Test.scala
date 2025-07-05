package io.github.pjfanning.fury

import org.apache.fory.Fory
import org.apache.fory.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FuryEnum3Test extends AnyWordSpec with Matchers {
  "fury scala enum support" should {
    "serialize/deserialize ColorEnum" in {
      val fury = Fory.builder().withLanguage(Language.JAVA).requireClassRegistration(false).build()
      //fury.register(classOf[ColorEnum])
      //fury.register(Class.forName("io.github.pjfanning.fury.ColorEnum$$anon$1"))
      val bytes = fury.serialize(ColorEnum.Green)
      fury.deserialize(bytes) shouldBe ColorEnum.Green
    }
  }
}
