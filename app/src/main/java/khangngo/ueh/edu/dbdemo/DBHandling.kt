package khangngo.ueh.edu.dbdemo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandling(context :Context) : SQLiteOpenHelper(context, "course.db", null, 1){
    override fun onCreate(p0: SQLiteDatabase?) {
        val sql = "create table users(email text primary key, password text)"
        p0?.execSQL(sql)
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addUser(email: String, password: String){
        val db = this .writableDatabase
        var values = ContentValues()
        values.put("email", email)
        values.put("password", password)

        db.insert("users", null, values)
    }

    fun getUser(email: String, password: String): Boolean{
        val db = this.readableDatabase
        val cursor = db.rawQuery("select * from users where email = ? and password = ?",
            arrayOf(email, password))
        var ret = false
        if (cursor.count > 0){
            ret = true
        }
        return ret
    }
}