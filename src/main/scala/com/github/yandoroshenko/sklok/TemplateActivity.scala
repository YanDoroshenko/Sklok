package com.github.yandoroshenko.sklok

import android.graphics.Color
import org.scaloid.common._

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

      STextView("Me too")
      STextView("I am taller than you").textSize(15 dip) // overriding
      SEditText("Yellow input field")

    }.padding(20 dip)
  }
}