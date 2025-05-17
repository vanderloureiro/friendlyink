package dev.vanderloureiro
package services

import dev.vanderloureiro.models.Link
import doobie.Transactor
import zio.{Task, UIO, URLayer, ZLayer}
import doobie.*
import doobie.hikari.HikariTransactor
import doobie.implicits.*
import zio.*
import zio.interop.catz.*

private class LinkRepository(xa: Transactor[Task]) {

  def getAll(): UIO[List[Link]] =
      sql"SELECT id, link, friendly_link FROM links"
        .query[Link]
        .to[List]
        .transact(xa)
        .orDie
}

object LinkRepository {
  val layer: ZLayer[HikariTransactor[Task], Nothing, LinkRepository] =
    ZLayer.fromFunction(new LinkRepository(_))
}
