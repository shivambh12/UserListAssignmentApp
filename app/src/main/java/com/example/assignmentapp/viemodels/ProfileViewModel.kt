package com.example.assignmentapp.viemodels

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentapp.api.RetrofitInstance
import com.example.assignmentapp.models.Profile
import com.example.assignmentapp.repository.ProfileRepository
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel() {
    val profileRepository = ProfileRepository()
    val users:MutableLiveData<Profile> = MutableLiveData()
    fun getUsers()
    {
        viewModelScope.launch {
            users.value=profileRepository.getprofiles()
        }
    }
}