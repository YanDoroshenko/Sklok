package com.github.yandoroshenko.sklok.weather

/**
  * Created by Yan Doroshenko (yandoroshenko@protonmail.com) on 02.06.2017.
  */
case class Weather(t: Int)

sealed trait MeasurementUnit {
  val index: Int
}

case object C extends MeasurementUnit {
  override val index: Int = 0
}

case object F extends MeasurementUnit {
  override val index: Int = 1
}