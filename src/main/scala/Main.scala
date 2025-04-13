package dev.vanderloureiro

import zio._
import zio.http._
import zio.ZIOAppDefault

object Main extends ZIOAppDefault {
  // Responds with plain text
  val homeRoute =
    Method.GET / Root -> handler(Response.text("Friendlyink"))

  // Responds with JSON
  val jsonRoute =
    Method.GET / "json" -> handler(Response.json("""{"title": "Friendly Link"}"""))

  // Create HTTP route
  val app = Routes(homeRoute, jsonRoute)

  // Run it like any simple app
  override val run = Server.serve(app).provide(Server.default)
}


