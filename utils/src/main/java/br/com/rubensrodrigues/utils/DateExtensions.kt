package br.com.rubensrodrigues.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun String.getDate(pattern: String = "yyyy-MM-dd"): Date {
    val dateFormat = SimpleDateFormat(
        pattern,
        Locale.getDefault()
    )
    return dateFormat.parse(this) ?: throw IllegalArgumentException("Invalid date format")
}

fun String.getMonth(pattern: String = "yyyy-MM-dd"): String {
    val calendar = Calendar.getInstance()
    calendar.time = this.getDate(pattern)
    val month = calendar.getDisplayName(
        Calendar.MONTH,
        Calendar.LONG,
        Locale.getDefault()
    )
    return month
        .substring(
            startIndex = 0,
            endIndex = 3
        )
        .uppercase()
}

fun String.getDay(pattern: String = "yyyy-MM-dd"): String {
    val calendar = Calendar.getInstance()
    calendar.time = this.getDate(pattern)
    return calendar
        .get(Calendar.DAY_OF_MONTH)
        .toString()
}