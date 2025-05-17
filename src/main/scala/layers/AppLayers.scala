package dev.vanderloureiro
package layers

import services.{GetContactService, LinkRepository, LinkService}
import services.lives.{GetContactServiceLive, LinkServiceLive}

import io.github.gaelrenoux.tranzactio.doobie.Database
import zio.*

import javax.sql.DataSource

object AppLayers {

  val database: ZLayer[DataSource, Nothing, Database] =
    Database.fromDatasource
    
  val all: ULayer[GetContactService with LinkService] = ???
}
