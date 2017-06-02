package com.github.yandoroshenko.sklok.weather
import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL._
import org.joda.time.LocalDate

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by Yan Doroshenko (yandoroshenko@protonmail.com) on 02.06.2017.
  */
class GismeteoWeatherAcquirer extends WeatherAcquirer {
  override def get(d: LocalDate, u: MeasurementUnit): Future[Weather] = {
    Future{
      val browser = JsoupBrowser()
      val url = "http://gismeteo.com"
      val headline = browser.get(url) >?> element(".fcast")
      Weather(
        (browser.get(url + headline.get.attr("href")) >> element(".temp") >> elementList("dd") >> text(".value"))
          .map(_.dropRight(2).toInt).apply(u.index)
      )
    }
  }
}
