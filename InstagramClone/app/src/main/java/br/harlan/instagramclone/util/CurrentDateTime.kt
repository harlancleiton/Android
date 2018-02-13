package br.harlan.instagramclone.util

import java.text.SimpleDateFormat
import java.util.*

object CurrentDateTime {
    val currentDateTime: String
        get() {
            val currentDateTime: String
            val simpleDateFormat = SimpleDateFormat("ddMMyyyyHHmmss")
            val date = Calendar.getInstance().time
            currentDateTime = simpleDateFormat.format(date)
            return currentDateTime
        }
}