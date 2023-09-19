package codsoft.dagno1.quotelytics.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import codsoft.dagno1.o_dot.data.Task
import java.io.InputStream


class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    private val inputStream: InputStream = context.assets.open("data.sql")
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID + " INTEGER PRIMARY KEY, " +
                TITLE + " TEXT," +
                DESCRIPTION + " TEXT," +
                DUE_DATE + " INTEGER" +
                IS_CHECKED + " INT DEFAULT 0," +")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addTask(task: Task) {

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values
        // in the form of key-value pair
        values.put(TITLE, task.title)
        values.put(DESCRIPTION, task.description)
        values.put(IS_CHECKED, false)
        values.put(DUE_DATE, task.dudDate)

        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in our database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_NAME, null, values)

        // at last we are
        // closing our database
        db.close()
    }


    fun markTaskAsFinished(taskId: Int): Boolean {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(IS_CHECKED, 1)
        val whereClause = "$ID = ?"
        val whereArgs = arrayOf(taskId.toString())

        val rowsUpdated = db.update(TABLE_NAME, values, whereClause, whereArgs)
        return rowsUpdated > 0
    }



    companion object {
        private const val DATABASE_NAME = "O_DOT"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "tasks"
        const val ID = "id"
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val DUE_DATE = "due_date"
        const val IS_CHECKED = "is_checked"
    }
}