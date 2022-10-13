package sheridan.youho.assignment2.data

import androidx.room.TypeConverter
import java.util.Date

class DataConverters {

    @TypeConverter
    fun convertFromLongToDate(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun convertFromDateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun convertFromIntToString(scoredTeam: Int): String {
        return when(scoredTeam) {
            0 -> "A"
            else -> "B"
        }
    }

    @TypeConverter
    fun convertFromStringToInt(scoredTeam: String): Int {
        return when(scoredTeam) {
            "A" -> 0
            else -> 1
        }
    }

}