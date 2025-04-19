package dev.vanderloureiro
package routes

import zio.*
import zio.http.*
import zio.http.codec.*
import zio.http.codec.PathCodec.path
import zio.http.endpoint.*
import zio.http.endpoint.AuthType.None
import zio.http.endpoint.openapi.{OpenAPIGen, SwaggerUI}

object Routing {

  val getUser =
    Endpoint(Method.GET / "users" / int("userId")).out[Int]

  val getUserRoute =
    getUser.implement { id => ZIO.succeed(id) }

  val getUserPosts =
    Endpoint(Method.GET / "users" / int("userId") / "posts" / int("postId"))
      .query(HttpCodec.query[String]("name"))
      .out[List[String]]

  val getUserPostsRoute =
    getUserPosts.implement { case (id1: Int, id2: Int, query: String) =>
      ZIO.succeed(List(s"API2 RESULT parsed: users/$id1/posts/$id2?name=$query"))
    }

  val openAPI = OpenAPIGen.fromEndpoints(title = "Endpoint Example", version = "1.0", getUser, getUserPosts)

  val routes = Routes(getUserRoute, getUserPostsRoute) ++ SwaggerUI.routes("docs" / "openapi", openAPI)
  
}
