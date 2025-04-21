package dev.vanderloureiro
package layers

import cats.effect.Async
import doobie.hikari.HikariTransactor
import doobie.util.ExecutionContexts
import zio.*
import zio.interop.catz.*

object DatabaseLayer {
//
//  val live: ZLayer[Any, Throwable, HikariTransactor[Task]] = ZLayer.scoped {
//    for {
//      ce <- ZIO.executor.map(_.asExecutionContext)
//      xa <- HikariTransactor.newHikariTransactor[Task](
//        driverClassName = "org.postgresql.Driver",
//        url             = "jdbc:postgresql://localhost:5432/seu_banco",
//        user            = "seu_usuario",
//        pass            = "sua_senha",
//        connectEC       = ce
//      )
//    } yield xa
//  }
}
