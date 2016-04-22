package com.example

import akka.http.scaladsl.model.HttpMethods
import akka.http.scaladsl.server.MethodRejection
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.stream.ActorMaterializer
import org.scalatest.{Matchers, WordSpec}

class MyServiceSpec extends WordSpec with Matchers with MyService with ScalatestRouteTest  {

  override implicit val materializer: ActorMaterializer = ActorMaterializer()

  "MyService" should {

    "return a greeting for GET requests to the greeting path" in {
      Get("/greeting") ~> routes ~> check {
        responseAs[String] should include("Hello")
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> routes ~> check {
        handled shouldBe false
      }
    }

    "return a MethodNotAllowed error for PUT requests to the greeting path" in {
      Put("/greeting") ~> routes ~> check {
        handled shouldBe false
        rejection shouldBe MethodRejection(HttpMethods.GET)
      }
    }
  }
}

