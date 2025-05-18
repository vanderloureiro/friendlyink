package dev.vanderloureiro
package services.lives

import services.LinkService

import models.Link
import zio.{Ref, UIO, ULayer, ZLayer}

final case class LinkServiceLive(ref: Ref[Map[String, Link]]) extends LinkService {

  override def save(link: Link): UIO[Unit] = ref.update(_.updated(link.friendlyLink, link))

  override def get(friendly: String): UIO[Option[Link]] = ref.get.map(_.get(friendly))

  override def getAll: UIO[List[Link]] = ref.get.map(_.values.toList)
}

object LinkServiceLive {
  val layer: ULayer[LinkService] = ZLayer.fromZIO {
    Ref.make(Map.empty[String, Link]).map(LinkServiceLive(_))
  }
}