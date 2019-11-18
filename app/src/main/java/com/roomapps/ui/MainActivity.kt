package com.roomapps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.roomapps.Inject
import com.roomapps.R
import com.roomapps.database.Word
import com.roomapps.ui.WordAdapter.OnAdapterListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var wordAdapter: WordAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    private val newWordRequestCode = 1
    private val updateWordRequestCode = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = Inject.provideViewModelFactory(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        setupRecyclerView()
        fab.setOnClickListener {
            val intent = Intent(this, AddWordActivity::class.java)
            startActivityForResult(intent, newWordRequestCode)
        }
    }

    private fun setupRecyclerView(){
        wordAdapter = WordAdapter()
        recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = wordAdapter
        }

        wordAdapter.setOnAdapterListener(object: OnAdapterListener{
            override fun onClick(word: Word) {
                val intent = Intent(this@MainActivity, AddWordActivity::class.java)
                intent.putExtra(AddWordActivity.EDIT_WORD, word)
                startActivityForResult(intent, updateWordRequestCode)
            }
        })

        viewModel.getAllWord().observe(
            this, Observer<List<Word>>{
                wordAdapter.setWords(it)
            })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordRequestCode && resultCode == RESULT_OK) {
            data?.getSerializableExtra(AddWordActivity.WORD)?.let {
                val word = it as Word
                viewModel.insertWord(word)
            }
        } else if(requestCode == updateWordRequestCode && resultCode == RESULT_OK) {
            data?.getSerializableExtra(AddWordActivity.WORD)?.let {
                val word = it as Word
                viewModel.updateWord(word)
            }
        }
    }
}
