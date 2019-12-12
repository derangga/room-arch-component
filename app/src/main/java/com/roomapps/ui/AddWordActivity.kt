package com.roomapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.roomapps.R
import com.roomapps.database.Word
import kotlinx.android.synthetic.main.activity_add_word.*

class AddWordActivity : AppCompatActivity() {

    companion object{
        const val EDIT_WORD = "edit"
        const val WORD = "word"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        val dataIntent = intent
        var mWord: Word? = null

        if(dataIntent.hasExtra(EDIT_WORD)){
            mWord = dataIntent.getSerializableExtra(EDIT_WORD) as Word
            edit_word.setText(mWord.word)
        }

        button_save.setOnClickListener {
            if(edit_word.text.toString().isNotEmpty()){
                if(mWord == null){
                    addWord()
                } else editWord(mWord)
            } else {
                Toast.makeText(this, "Please fill the word text", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addWord(){
        val word = Word(word =  edit_word.text.toString())
        val data = Intent().apply {
            putExtra(WORD, word)
        }
        setResult(RESULT_OK, data)
        finish()
    }

    private fun editWord(wordObj: Word){
        wordObj.word = edit_word.text.toString()
        val data = Intent().apply {
            putExtra(WORD, wordObj)
        }
        setResult(RESULT_OK, data)
        finish()
    }
}
