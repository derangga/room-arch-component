package com.roomapps.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// TODO: 1. Buat entity

@Entity(tableName = "tb_word")
data class Word (@ColumnInfo(name = "word") var word: String): Serializable{
    @PrimaryKey(autoGenerate = true)
    var pkId: Int = 0
}