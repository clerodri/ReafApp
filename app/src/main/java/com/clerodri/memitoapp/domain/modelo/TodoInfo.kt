package com.clerodri.memitoapp.domain.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TodoInfo(

    val title: String,
    val valor: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
