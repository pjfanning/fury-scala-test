# fury-scala-test
 
Test using [Fury](https://github.com/alipay/fury) serialization with Scala classes.

It is recommended that you read the [Fury Scala Guide](https://github.com/alipay/fury/blob/main/docs/guide/scala_guide.md).

Ideally, users should not disable class registration because this is an important protection against
[Remote Code Execution](https://en.wikipedia.org/wiki/Arbitrary_code_execution).

The problem is that you need to register a number of internal Scala classes when using features like
* Options
* Collections
* Enumerations
* Objects (Scala 2.13+)

This is because Fury relies on internal Scala class serialization and this exposes the innards of the Scala
class representation. Have a look at the test cases in this project to see some examples.

Fury has not been optimized for Scala class uses. There are open issues but it could be a big undertaking to create optimized serializers/deserailizers
for Scala collections, etc.
