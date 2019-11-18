package com.roomapps.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roomapps.database.Word
import com.roomapps.database.WordRepos
import kotlinx.coroutines.launch

// TODO: 7. Buat class MainViewModel extends ViewModel
class MainViewModel(private val wordRepos: WordRepos): ViewModel() {

    fun getAllWord(): LiveData<List<Word>> = wordRepos.getAllWord()

    fun insertWord(word: Word){
        viewModelScope.launch {
            wordRepos.insert(word)
        }
    }

    fun updateWord(word: Word){
        viewModelScope.launch {
            wordRepos.update(word)
        }
    }
}