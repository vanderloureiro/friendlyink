package dev.vanderloureiro
package services.lives

import services.GetContactService

import zio.{UIO, ULayer, ZIO, ZLayer}

final case class GetContactServiceLive() extends GetContactService {
  
  override def execute(): UIO[String] = ZIO.succeed("vanderloureiroleite@gmail.com")
}

object GetContactServiceLive {
  val layer: ULayer[GetContactService] = ZLayer.succeed(GetContactServiceLive())
}