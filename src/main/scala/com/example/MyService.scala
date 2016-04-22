package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

trait Config {
  private val config = ConfigFactory.load()
  private val httpConfig = config.getConfig("http")

  val httpInterface = httpConfig.getString("interface")
  val httpPort = httpConfig.getInt("port")
}

trait HttpService extends Config {

  protected def system: ActorSystem

  protected def materializer: ActorMaterializer

}

import scala.language.postfixOps


// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService {

  val routes =
    path("greeting") {
      get {
        parameters('name ?) { name =>
          complete {
            <html>
              <body>
                <h1>Hello <i>{name.getOrElse("World")}</i>!</h1>
              </body>
            </html>
          }
        }
      }
    }
}