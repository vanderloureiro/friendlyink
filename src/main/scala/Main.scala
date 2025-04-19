package dev.vanderloureiro

import dev.vanderloureiro.routes.Routing
import zio.*
import zio.http.*
import zio.ZIOAppDefault

object Main extends ZIOAppDefault {
  
  private val app = Routing.routes;

  override val run: ZIO[Any, Throwable, Nothing] = Server.serve(app).provide(Server.default)
}


