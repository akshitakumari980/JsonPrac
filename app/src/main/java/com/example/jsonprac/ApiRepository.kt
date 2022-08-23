package com.example.jsonprac

class ApiRepository constructor(private val apiService: ApiService) {
    fun getUsers()= apiService.getUsers()
}