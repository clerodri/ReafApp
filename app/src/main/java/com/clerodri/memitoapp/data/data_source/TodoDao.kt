package com.clerodri.memitoapp.data.data_source

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.clerodri.memitoapp.domain.modelo.TodoInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todoInfo: TodoInfo)

    @Delete
    suspend fun delete(todoInfo: TodoInfo)

    @Query("SELECT * FROM todo_table")
    fun getAll(): Flow<List<TodoInfo>>
}
/*
    @Update
    suspend fun update(todoInfo: TodoInfo)

    @Query("SELECT * FROM todo_table WHERE id = :todoId")
    suspend fun get(todoId: Long): LiveData<TodoInfo>*/


