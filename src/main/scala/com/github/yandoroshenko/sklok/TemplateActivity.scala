package com.github.yandoroshenko.sklok

import android.graphics.Color
import com.github.yandoroshenko.sklok.weather.{C, GismeteoWeatherAcquirer}
import org.joda.time.LocalDate
import org.scaloid.common._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
  * Created by Yan Doroshenko (yandoroshenko@protonmail.com) on 07.05.2017.
  */
class TemplateActivity extends SActivity {

  onCreate {
    contentView = new SVerticalLayout {
      style {
        case t: STextView => t.textSize(10 dip)
        case v: SEditText => v.backgroundColor(Color.YELLOW)
      }

      val t = STextView("Please wait")

      val f = new GismeteoWeatherAcquirer().get(LocalDate.now(), C)
        f.onComplete {
        case Success(w) => t.text = w.toString
        case Failure(e) => t.text = e.getMessage
      }

      Await.result(f, 10 second)

      STextView("I am taller than you").textSize(15 dip) // overriding
      SEditText("Yellow input field")
    }.padding(20 dip)
  }
}