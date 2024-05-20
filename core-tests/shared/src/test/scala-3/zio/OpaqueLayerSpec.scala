package zio

import zio.test._
import zio.test.Assertion._
import zio.Random
import zio.test.Gen._

object UserName {
  opaque type T = String
  object T {
    def apply(v: String): T = v
  }
}

object OpaqueLayerSpec extends ZIOBaseSpec {

  def spec = 
    suite("Opaque Spec")(
      test("test") {
        ZIO.serviceWithZIO[UserName.T](x => Console.printLine(x))
          .provide(ZLayer.succeed(UserName.T("userName")))

        assertTrue(true)
      }
    )

}