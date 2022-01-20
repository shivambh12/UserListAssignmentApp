package com.example.assignmentapp.api

import com.example.assignmentapp.models.Profile
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileApi {
    @GET("api/933015671865098240")
    suspend fun getProfiles():Profile
}