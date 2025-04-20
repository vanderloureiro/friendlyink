package dev.vanderloureiro
package services

import dev.vanderloureiro.models.Link
import zio._

trait LinkService {
  def save(link: Link): UIO[Unit]

  def get(friendly: String): UIO[Option[Link]]

  def getAll(): UIO[List[Link]]
}

object LinkService {
  def save(link: Link): ZIO[LinkService, Nothing, Unit] =
    ZIO.serviceWithZIO[LinkService](_.save(link))

  def get(friendly: String): ZIO[LinkService, Nothing, Option[Link]] =
    ZIO.serviceWithZIO[LinkService](_.get(friendly))

  def getAll(): ZIO[LinkService, Nothing, List[Link]] =
    ZIO.serviceWithZIO[LinkService](_.getAll())
}

