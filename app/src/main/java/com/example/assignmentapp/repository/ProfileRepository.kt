package com.example.assignmentapp.repository

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.example.assignmentapp.activity.MainActivity
import com.example.assignmentapp.api.RetrofitInstance
import com.example.assignmentapp.models.User

class ProfileRepository() {
    suspend fun getprofiles()=RetrofitInstance.api.getProfiles()

}