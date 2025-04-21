package dev.vanderloureiro

import routes.LinkRoutes
import services.LinkService

import dev.vanderloureiro.layers.AppLayers
import zio.*
import zio.http.*
import zio.ZIOAppDefault

object Main extends ZIOAppDefault {
  
  private val app = LinkRoutes.routes

  override def run: ZIO[Any, Throwable, Nothing] =
    Server.serve(app).provide(
      Server.default,
      AppLayers.all
    )

}


