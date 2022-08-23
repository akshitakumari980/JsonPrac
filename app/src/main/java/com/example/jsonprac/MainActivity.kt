package com.example.jsonprac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonprac.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ApiViewModel
    private val retrofitService = ApiService.getInstance()
    val adapter = JAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(ApiRepository(retrofitService))).get(ApiViewModel::class.java)
        binding.myrecyclerview.adapter = adapter
        binding.myrecyclerview.layoutManager = LinearLayoutManager(this)
        viewModel.userList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setUserList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getUsers()
    }
}