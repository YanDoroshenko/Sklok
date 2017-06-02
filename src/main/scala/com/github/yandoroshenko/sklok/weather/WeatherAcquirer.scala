package com.github.yandoroshenko.sklok.weather

import org.joda.time.LocalDate

import scala.concurrent.Future

/**
  * Created by Yan Doroshenko (yandoroshenko@protonmail.com) on 02.06.2017.
  */
trait WeatherAcquirer {
  def get(d: LocalDate, u: MeasurementUnit): Future[Weather]
}