package codsoft.dagno1.o_dot.data

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Task(
    val id: Int,
    var title: String,
    var description: String?,
    var dudDate: Long,
    var isFinished: Boolean,
    var finishedDate: Long?
) {
    companion object {
        private const val DATE_FORMAT = "MM/dd/yyyy"

        fun timestampToDate(timestamp: Long): String {
            val sdf = SimpleDateFormat(DATE_FORMAT, Locale.US)
            val date = Date(timestamp)
            return sdf.format(date)
        }

        fun dateToTimestamp(dateString: String): Long {
            val sdf = SimpleDateFormat(DATE_FORMAT, Locale.US)
            val date = sdf.parse(dateString)
            return date?.time ?: 0L
        }
    }


}