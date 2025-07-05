package io.github.pjfanning.fury

import org.apache.fory.Fory
import org.apache.fory.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.runtime.ModuleSerializationProxy

class FuryOption213Test extends AnyWordSpec with Matchers {
  "fury scala option support" should {
    "serialize/deserialize Option[Long]" in {
      val fury = Fory.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[Option[_]])
      fury.register(classOf[Some[_]])
      fury.register(None.getClass)
      fury.register(classOf[ModuleSerializationProxy])
      val opt: Option[Long] = Some(123)
      val bytes = fury.serialize(opt)
      fury.deserialize(bytes) shouldEqual opt
    }
    "serialize/deserialize None" in {
      val fury = Fory.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[Option[_]])
      fury.register(classOf[Some[_]])
      fury.register(None.getClass)
      fury.register(classOf[ModuleSerializationProxy])
      val opt: Option[Long] = None
      val bytes = fury.serialize(opt)
      fury.deserialize(bytes) shouldEqual opt
    }
  }
}
