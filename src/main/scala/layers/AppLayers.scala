package dev.vanderloureiro
package layers

import services.{GetContactService, LinkService}
import services.lives.{GetContactServiceLive, LinkServiceLive}

import zio.*

object AppLayers {

  val all: ULayer[GetContactService with LinkService] = GetContactServiceLive.layer ++ LinkServiceLive.layer
}
