package com.clerodri.memitoapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clerodri.memitoapp.domain.modelo.TodoInfo

@Database(entities = [TodoInfo::class], version = 1, exportSchema = false)
abstract class TodoDataBase : RoomDatabase() {

    abstract val todoDao: TodoDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}