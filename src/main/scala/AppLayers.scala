package dev.vanderloureiro

import dev.vanderloureiro.models.Link
import dev.vanderloureiro.repository.LinkRepository
import dev.vanderloureiro.services.LinkService
import zio.*

object AppLayers {
  
  val all: ULayer[LinkService] = ZLayer.fromZIO {
    Ref.make(Map.empty[String, Link]).map(LinkRepository(_))
  }
}
