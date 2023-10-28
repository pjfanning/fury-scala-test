package io.github.pjfanning.fury

import io.fury.Fury
import io.fury.config.Language
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class FuryOption212Test extends AnyWordSpec with Matchers {
  "fury scala option support" should {
    "serialize/deserialize Option[Long]" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[Option[_]])
      fury.register(classOf[Some[_]])
      fury.register(None.getClass)
      val opt: Option[Long] = Some(123)
      val bytes = fury.serialize(opt)
      fury.deserialize(bytes) shouldEqual opt
    }
    "serialize/deserialize None" in {
      val fury = Fury.builder().withLanguage(Language.JAVA).build()
      fury.register(classOf[Option[_]])
      fury.register(classOf[Some[_]])
      fury.register(None.getClass)
      val opt: Option[Long] = None
      val bytes = fury.serialize(opt)
      fury.deserialize(bytes) shouldEqual opt
    }
  }
}
