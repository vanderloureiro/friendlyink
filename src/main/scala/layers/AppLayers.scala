package dev.vanderloureiro
package layers

import models.Link
import repository.LinkRepository
import services.LinkService

import dev.vanderloureiro.services.lives.GetContactServiceLive
import zio.*

object AppLayers {
  
  val dbLayer = DatabaseLayer.live
  
  val linkServiceLayer = LinkService.live
  
  val getContactServiceLayer = GetContactServiceLive.layer
  
  val all: ULayer[LinkService] = ZLayer.fromZIO {
    Ref.make(Map.empty[String, Link]).map(LinkRepository(_))
  }
}
