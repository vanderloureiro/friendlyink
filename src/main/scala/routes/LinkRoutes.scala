package dev.vanderloureiro
package routes

import dev.vanderloureiro.models.Link
import dev.vanderloureiro.services.LinkService
import zio.*
import zio.json.*
import zio.http.*

object LinkRoutes {
  
  val routes: Routes[LinkService, Response] = Routes(
    Method.GET / "link" -> handler {
      (_: Request) => for {
        links <- LinkService.getAll()
        json = links.toJson
      } yield Response.json(json)
    },

    Method.POST / "link" -> handler { (req: Request) =>
      for {
        body <- req.body.asString
        link <- ZIO.fromEither(body.fromJson[Link])
        _ <- LinkService.save(link)
      } yield Response.text("Link salvo com sucesso!")
    }.catchAll(_ => handler(Response.text("Erro ao salvar link"))),

    Method.GET / "link" / string("friendly") ->
      handler { (friendly: String, _: Request) =>
        LinkService.get(friendly).flatMap {
          case Some(link) => URL.decode(link.link) match {
            case Right(url) => ZIO.succeed(Response.redirect(url))
            case Left(_) => ZIO.succeed(Response.status(Status.NotFound))
          }
          case None => ZIO.succeed(Response.status(Status.NotFound))
        }
      },

    Method.DELETE / "todo" / string("id") ->
    handler { (id: String, req: Request) =>
      Response.text(s"This will remove a TODO item with id: $id")
    }
  )
}

