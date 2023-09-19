package codsoft.dagno1.quotelytics.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import codsoft.dagno1.o_dot.data.Task


class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID + " INTEGER PRIMARY KEY, " +
                TITLE + " TEXT," +
                DESCRIPTION + " TEXT," +
                DUE_DATE + " INTEGER," +
                IS_FINISHED + " INT DEFAULT 0," +
                FINISHED_DATE + " INTEGER" +")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addTask(task: Task) {
        val values = ContentValues()
        values.put(TITLE, task.title)
        values.put(DESCRIPTION, task.description)
        values.put(IS_FINISHED, false)
        values.put(DUE_DATE, task.dudDate)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }
    // Define a method in your DBHelper class
    @SuppressLint("Range")
    fun getTaskById(taskId: Int): Task? {
        val db = readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            null,
            "$ID = ?",
            arrayOf(taskId.toString()),
            null,
            null,
            null
        )

        return if (cursor.moveToFirst()) {
            val id = cursor.getInt(cursor.getColumnIndex(ID))
            val title = cursor.getString(cursor.getColumnIndex(TITLE))
            val description = cursor.getString(cursor.getColumnIndex(DESCRIPTION))
            val dueDate = cursor.getLong(cursor.getColumnIndex(DUE_DATE))
            val isFinished = cursor.getInt(cursor.getColumnIndex(IS_FINISHED)) == 1
            val finishedDate = cursor.getLong(cursor.getColumnIndex(FINISHED_DATE))

            Task(id, title, description, dueDate, isFinished, finishedDate)
        } else {
            null // Task with the given ID not found
        }
    }


    fun updateTask(updatedTask: Task): Boolean {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(TITLE, updatedTask.title)
        values.put(DESCRIPTION, updatedTask.description)
            values.put(DUE_DATE, updatedTask.dudDate)
        values.put(IS_FINISHED, if (updatedTask.isFinished) 1 else 0)
        values.put(FINISHED_DATE, updatedTask.finishedDate)
        val whereClause = "$ID = ?"
        val whereArgs = arrayOf(updatedTask.id.toString())
        val rowsUpdated = db.update(TABLE_NAME, values, whereClause, whereArgs)
        return rowsUpdated > 0
    }
    fun markTaskIsFinishedStatus(task: Task): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(IS_FINISHED, if (task.isFinished) 1 else 0)
        if (task.isFinished) {
            values.put(FINISHED_DATE, task.finishedDate)
        }
        val whereClause = "$ID = ?"
        val whereArgs = arrayOf(task.id.toString())

        val rowsUpdated = db.update(TABLE_NAME, values, whereClause, whereArgs)
        return rowsUpdated > 0
    }



    @SuppressLint("Range")
    fun getAllUnfinishedTasks(): List<Task> {
        val tasks = mutableListOf<Task>()
        val db = this.readableDatabase

        val cursor: Cursor = db.query(
            TABLE_NAME,
            null,
            "$IS_FINISHED = 0",
            null,
            null,
            null,
            "$DUE_DATE ASC" // Order by due date ascending
        )

        while (cursor.moveToNext()) {
            tasks.add(Task(
                cursor.getInt(cursor.getColumnIndex(ID)),
                cursor.getString(cursor.getColumnIndex(TITLE)),
                cursor.getString(cursor.getColumnIndex(DESCRIPTION)),
                cursor.getLong(cursor.getColumnIndex(DUE_DATE)),
                cursor.getInt(cursor.getColumnIndex(IS_FINISHED)) == 1,
                cursor.getLong(cursor.getColumnIndex(FINISHED_DATE))
            ))
        }
        cursor.close()
        return tasks
    }

    @SuppressLint("Range")
    fun getAllFinishedTasks(): List<Task> {
        val tasks = mutableListOf<Task>()
        val db = this.readableDatabase

        val cursor: Cursor = db.query(
            TABLE_NAME,
            null,
            "$IS_FINISHED = 1",
            null,
            null,
            null,
            "$FINISHED_DATE DESC" // Order by finished date descending
        )

        while (cursor.moveToNext()) {
            tasks.add(Task(
                cursor.getInt(cursor.getColumnIndex(ID)),
                cursor.getString(cursor.getColumnIndex(TITLE)),
                cursor.getString(cursor.getColumnIndex(DESCRIPTION)),
                cursor.getLong(cursor.getColumnIndex(DUE_DATE)),
                cursor.getInt(cursor.getColumnIndex(IS_FINISHED)) == 1,
                cursor.getLong(cursor.getColumnIndex(FINISHED_DATE))
            ))
        }

        cursor.close()
        return tasks
    }


companion object {
        private const val DATABASE_NAME = "O_DOT"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "tasks"
        const val ID = "id"
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val DUE_DATE = "due_date"
        const val IS_FINISHED = "is_finished"
        const val FINISHED_DATE = "finished_date"
    }
}