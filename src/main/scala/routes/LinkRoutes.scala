package dev.vanderloureiro
package routes

import models.Link
import services.LinkService

import zio.*
import zio.http.*
import zio.json.*

object LinkRoutes {

  private val listLinks = handler {
    (_: Request) => for {
      links <- LinkService.getAll()
      json = links.toJson
    } yield Response.json(json)
  }

  private val createLink = handler { (req: Request) =>
    for {
      body <- req.body.asString
      link <- ZIO.fromEither(body.fromJson[Link])
      _ <- LinkService.save(link)
    } yield Response.text("Link salvo com sucesso!")
  }.catchAll(_ => handler(Response.text("Erro ao salvar link")))

  private val getLink = handler { (friendly: String, _: Request) =>
    LinkService.get(friendly).flatMap {
      case Some(link) => URL.decode(link.link) match {
        case Right(url) => ZIO.succeed(Response.redirect(url))
        case Left(_) => ZIO.succeed(Response.status(Status.NotFound))
      }
      case None => ZIO.succeed(Response.status(Status.NotFound))
    }
  }

  val routes: Routes[LinkService, Response] = Routes(
    Method.GET / "link" -> listLinks,

    Method.POST / "link" -> createLink,

    Method.GET / "link" / string("friendly") -> getLink
  )
}

