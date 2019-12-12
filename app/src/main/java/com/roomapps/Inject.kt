package com.roomapps

import android.content.Context
import com.roomapps.database.WordDatabase
import com.roomapps.database.WordRepos
import com.roomapps.ui.MainViewModelFactory

/** TODO: 6. Buat object class Inject
 * Class ini digunakan untuk menyediakan depedency yang dibutuhkan  tiap-tiap class
 */
object Inject {

    fun provideWordRepos(context: Context): WordRepos {
        val wordDb = WordDatabase.getDatabase(context)
        return WordRepos(wordDb.wordDao())
    }

    fun provideViewModelFactory(context: Context): MainViewModelFactory {
        val repos = provideWordRepos(context)
        return MainViewModelFactory(repos)
    }
}