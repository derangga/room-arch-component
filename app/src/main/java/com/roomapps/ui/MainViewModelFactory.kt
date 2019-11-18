package com.roomapps.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.roomapps.database.WordRepos


/** TODO: 5. Buat class MainViewModelFactory extends ViewModelProvider.Factory
 * Class ini digunakan untuk passing variable ke constructor viewnidel
 */
class MainViewModelFactory(private val wordRepos: WordRepos): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(WordRepos::class.java).newInstance(wordRepos)
    }
}