package com.roomapps.database

import androidx.lifecycle.LiveData

/** TODO: 4. Buat class repository
 * Single source of truth untuk app yang akan dibuat
 * Semua transaksi database dengan dao akan di manajemen pada class ini
 */
class WordRepos(private val wordDao: WordDao) {

    suspend fun insert(word: Word){
        wordDao.insertWord(word)
    }

    suspend fun update(word: Word){
        wordDao.updateWord(word)
    }

    fun getAllWord(): LiveData<List<Word>> = wordDao.getAllWord()
}