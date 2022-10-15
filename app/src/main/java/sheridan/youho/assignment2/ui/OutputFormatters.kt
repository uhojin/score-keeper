package sheridan.youho.assignment2.ui

import sheridan.youho.assignment2.model.ScoreData
import java.text.NumberFormat
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

private val dateFormatter =
    DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy")

private val timeFormatter = DateTimeFormatter.ofPattern("h:mm:ss a")

private val dateAndTimeFormatter =
    DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy - h:mm a")

fun formatDate(date: Date): String =
    date.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
        .format(dateFormatter)

fun formatTime(date: Date): String =
    date.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalTime()
        .format(timeFormatter)


fun formatDateAndTime(date: Date): String =
    date.toInstant()
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime()
        .format(dateAndTimeFormatter)

fun formatScore(score: Int) = NumberFormat.getIntegerInstance().format(score)