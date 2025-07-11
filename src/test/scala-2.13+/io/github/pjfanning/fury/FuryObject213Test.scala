package io.github.pjfanning.fury

import org.apache.fory.Fory
import org.apache.fory.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.runtime.ModuleSerializationProxy

class FuryObject213Test extends AnyWordSpec with Matchers {
  "fury scala object support" should {
    "serialize/deserialize SampleObject" in {
      val fury = Fory.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[ModuleSerializationProxy])
      fury.register(SampleObject.getClass)
      val bytes = fury.serialize(SampleObject)
      fury.deserialize(bytes) shouldBe SampleObject
    }
  }
}
