package com.cernsonmez.hilt.api

import com.cernsonmez.hilt.model.User
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>
}