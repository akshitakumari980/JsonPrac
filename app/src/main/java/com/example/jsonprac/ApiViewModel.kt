package com.example.jsonprac

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jsonprac.model.ModelUser
import retrofit2.Call
import retrofit2.Response


class ApiViewModel constructor(private val repository: ApiRepository)  : ViewModel() {

    val userList = MutableLiveData<List<ModelUser>>()
    val errorMessage = MutableLiveData<String>()

    fun getUsers() {
        val response = repository.getUsers()
        response.enqueue(object : retrofit2.Callback<MutableList<ModelUser>> {
            override fun onResponse(
                call: Call<MutableList<ModelUser>>,
                response: Response<MutableList<ModelUser>>
            ) {
                userList.postValue(response.body())
            }
            override fun onFailure(call: Call<MutableList<ModelUser>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}