package com.example.assignmentapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentapp.R
import com.example.assignmentapp.adapter.ProfileAdapter
import com.example.assignmentapp.databinding.ActivityMainBinding
import com.example.assignmentapp.models.Profile
import com.example.assignmentapp.models.User
import com.example.assignmentapp.repository.ProfileRepository
import com.example.assignmentapp.viemodels.ProfileViewModel

class MainActivity : AppCompatActivity() {
    lateinit var madapter: ProfileAdapter
    lateinit var binding:ActivityMainBinding
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        val list:ArrayList<User> = ArrayList()
       madapter= ProfileAdapter()
       binding.recyclerview.layoutManager= LinearLayoutManager(this)
       binding.recyclerview.adapter=madapter
     val viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
       binding.progressBar.visibility= View.VISIBLE
     viewModel.getUsers()
     viewModel.users.observe(this, Observer {
         Log.e("error123","${it}")
         for(user in it.users)
         {
             list.add(user)
         }
         var sortedList = list.sortedWith(compareBy({ it.age }))
         binding.progressBar.visibility= View.GONE
         madapter.updatelist(sortedList)
     })

    }

}