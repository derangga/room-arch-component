package com.roomapps.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// TODO: 1. Buat entity

@Entity(tableName = "tb_word")
data class Word (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var pkId: Int = 0,
    @ColumnInfo(name = "word") var word: String): Serializable