package sheridan.youho.assignment2.ui

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.Date

@BindingAdapter("dateValue")
fun setDateValue(textView: TextView, date: Date?) {
    if (date is Date)
        textView.text = formatDate(date)
}

@BindingAdapter("timeValue")
fun setTimeValue(textView: TextView, date: Date?) {
    if (date is Date)
        textView.text = formatTime(date)
}

@BindingAdapter("dateAndTimeValues")
fun setDateAndTimeValues(textView: TextView, date: Date?) {
    if (date is Date)
        textView.text = formatDateAndTime(date)
}

@BindingAdapter("scoreValue")
fun setScoreValue(textView: TextView, score: Int?) {
    if (score is Int) {
        textView.text = formatScore(score)
    }
}

