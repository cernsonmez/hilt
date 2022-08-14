package com.cernsonmez.hilt.repository

import com.cernsonmez.hilt.api.ApiHelper
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()

}