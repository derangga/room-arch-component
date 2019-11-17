package com.roomapps.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// TODO: 2. Buat Data Access Object

@Dao
interface WordDao {

    @Insert
    suspend fun insertWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    @Query("select * from tb_word")
    fun getAllWord(): LiveData<List<Word>>
}