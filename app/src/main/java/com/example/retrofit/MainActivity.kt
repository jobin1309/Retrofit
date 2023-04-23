package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.MyAdapter
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    private lateinit var viewModel: MainViewModel;
    private val myAdapter by lazy {
        MyAdapter();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);

        setContentView(binding.root)


        setUpRecyclerView();


        val repository = Repository();
        val viewModelFactory = MainViewModelFactory(repository);
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java];

        var random = (1..10).random();
        viewModel.getCustomPost(random, "id", "desc");

        viewModel.customPost.observe(this, Observer { response ->
            if (response.isSuccessful) {
//                response.body()?.let { myAdapter.setData(it) }
                response.body()?.let { myAdapter.setData(it) }

            } else {
                Toast.makeText(this, response.code(), Toast.LENGTH_LONG).show();
            }


        })


    }

    private fun setUpRecyclerView() {
        binding.recyclerView.adapter = myAdapter;
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this
        )
    }
}