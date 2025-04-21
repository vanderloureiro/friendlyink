package dev.vanderloureiro
package services

import zio.{UIO, ZIO, ZLayer}

trait GetContactService {

  def execute(): UIO[String]
}

object GetContactService {
  def execute(): ZIO[GetContactService, Nothing, String] = ZIO.serviceWithZIO[GetContactService](_.execute())
}