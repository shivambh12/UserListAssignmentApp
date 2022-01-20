package com.example.assignmentapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentapp.R
import com.example.assignmentapp.models.User

class ProfileAdapter(): RecyclerView.Adapter<NewsViewHolder>() {
    private val items:ArrayList<User> =ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        val viewholder=NewsViewHolder(view)

        return viewholder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val curentitem=items[position]
        holder.name.text=curentitem.firstName+" "+curentitem.lastName
        holder.email.text=curentitem.email
        holder.age.text=curentitem.age.toString()
        Glide.with(holder.itemView.context).load(curentitem.imageUrl).into(holder.profilepic)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun updatelist(updateitems :List<User>)
    {
        items.clear()
        items.addAll(updateitems)
        notifyDataSetChanged()
    }
}
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView =itemView.findViewById(R.id.name)
    val profilepic: ImageView =itemView.findViewById(R.id.imageView)
    val email:TextView=itemView.findViewById(R.id.email)
    val age:TextView= itemView.findViewById(R.id.age)
}
