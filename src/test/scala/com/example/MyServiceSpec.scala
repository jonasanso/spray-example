package com.example

import org.specs2.mutable.Specification
import spray.http.Uri.Query
import spray.testkit.Specs2RouteTest
import spray.http._
import StatusCodes._

class MyServiceSpec extends Specification with Specs2RouteTest with MyService {
  def actorRefFactory = system
  
  "MyService" should {

    "return a greeting for GET requests to the greeting path" in {
      Get("/greeting") ~> myRoute ~> check {
        responseAs[String] must contain("Hello")
      }
    }

    "return a greeting for GET requests to the greeting path with name parameter" in {
      Get("/greeting?name=test") ~> myRoute ~> check {
        responseAs[String] must contain("Hello")
        responseAs[String] must contain("test")
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> myRoute ~> check {
        handled must beFalse
      }
    }

    "return a MethodNotAllowed error for PUT requests to the greeting path" in {
      Put("/greeting") ~> sealRoute(myRoute) ~> check {
        status === MethodNotAllowed
        responseAs[String] === "HTTP method not allowed, supported methods: GET"
      }
    }
  }
}
