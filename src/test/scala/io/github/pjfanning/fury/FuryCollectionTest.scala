package io.github.pjfanning.fury

import org.apache.fory.Fory
import org.apache.fory.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FuryCollectionTest extends AnyWordSpec with Matchers {
  "fury scala collection support" should {
    "serialize/deserialize SetWrapper" in {
      val fury = Fory.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[Set[_]])
      fury.register(ScalaClasses.ScalaSet2Class)
      fury.register(classOf[SetWrapper[_]])
      val setWrapper = SetWrapper(Set(1234567890L, 9876543210L))
      val bytes = fury.serialize(setWrapper)
      fury.deserialize(bytes) shouldEqual setWrapper
    }
  }
}
