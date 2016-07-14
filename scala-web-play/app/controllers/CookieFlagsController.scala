package controllers

import play.api.mvc.{Action, Controller, Cookie}

class CookieFlagsController extends Controller {

  def insecureCookie() = Action {
    Ok("Hello !").withCookies(Cookie("c1", "foo", secure = false))
  }

  def multipleInsecureCookies() = Action {
    Ok("Hello !").withCookies(
      Cookie("c1", "foo", secure = false),
      Cookie("c1", "foo", secure = false)
    )
  }

  def multipleSecureCookies() = Action {
    Ok("Hello !").withCookies(
      Cookie("c1", "foo", secure = false), // This must stay at line 20 - It has the .atLine annotation in the test
      Cookie("c1", "foo", secure = true)
    )
  }

  def safeSecureCookie() = Action {
    Ok("Hello !").withCookies(
      Cookie("c1", "foo", secure = true)
    )
  }

  def nonHttpOnlyCookie() = Action {
    Ok("Hello !").withCookies(Cookie("c1", "foo", httpOnly = false))
  }

  def multipleNonHttpOnlyCookie() = Action {
    Ok("Hello !").withCookies(
      Cookie("c1", "foo", httpOnly = false), // This must stay at line 37 - It has the .atLine annotation in the test
      Cookie("c1", "foo", httpOnly = false)
    )
  }

  def multipleHttpOnlyCookie() = Action {
    Ok("Hello !").withCookies(
      Cookie("c1", "foo", httpOnly = false),
      Cookie("c1", "foo", httpOnly = true)
    )
  }

  def safeHttpOnlyCookie() = Action {
    Ok("Hello !").withCookies(
      Cookie("c1", "foo", httpOnly = true)
    )
  }
}
