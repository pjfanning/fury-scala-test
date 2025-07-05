package io.github.pjfanning.fury

import org.apache.fory.Fory
import org.apache.fory.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FuryCollection212Test extends AnyWordSpec with Matchers {
  "fury scala collection support" should {
    "serialize/deserialize ListWrapper" in {
      val fury = Fory.builder().withLanguage(Language.JAVA).build()
      fury.register(Nil.getClass)
      fury.register(ScalaClasses.ScalaColonColonClass)
      fury.register(ScalaClasses.ScalaList$Class)
      fury.register(ScalaClasses.ScalaListSerializationProxyClass)
      fury.register(ScalaClasses.ScalaListSerializeEnd$Class)
      fury.register(classOf[ListWrapper[_]])
      val listWrapper = ListWrapper(List(1234567890L, 9876543210L))
      val bytes = fury.serialize(listWrapper)
      fury.deserialize(bytes) shouldEqual listWrapper
    }
    "serialize/deserialize ListWrapper with empty list" in {
      val fury = Fory.builder().withLanguage(Language.JAVA).build()
      fury.register(Nil.getClass)
      fury.register(ScalaClasses.ScalaColonColonClass)
      fury.register(ScalaClasses.ScalaList$Class)
      fury.register(ScalaClasses.ScalaListSerializationProxyClass)
      fury.register(ScalaClasses.ScalaListSerializeEnd$Class)
      fury.register(classOf[ListWrapper[_]])
      val listWrapper = ListWrapper(List.empty)
      val bytes = fury.serialize(listWrapper)
      fury.deserialize(bytes) shouldEqual listWrapper
    }
  }
}
