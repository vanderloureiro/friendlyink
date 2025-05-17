package dev.vanderloureiro
package models

import doobie.Read
import zio.json.*

case class Link(link: String, friendlyLink: String)

object Link {
  implicit val decoder: JsonDecoder[Link] = DeriveJsonDecoder.gen[Link]
  implicit val encoder: JsonEncoder[Link] = DeriveJsonEncoder.gen[Link]
  implicit val linkRead: Read[Link] =
    Read[(String, String)].map { case (link, friendly) => Link(link, friendly) }
}