package dev.vanderloureiro
package models

import zio.json._

final case class Link(link: String, friendlyLink: String)

object Link {
  implicit val decoder: JsonDecoder[Link] = DeriveJsonDecoder.gen[Link]
  implicit val encoder: JsonEncoder[Link] = DeriveJsonEncoder.gen[Link]
}