package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.Post

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Post>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.userId_txt).text =
            myList[position].userId.toString();
        holder.itemView.findViewById<TextView>(R.id.id_txt).text = myList[position].id.toString()
        holder.itemView.findViewById<TextView>(R.id.title_txt).text = myList[position].title
        holder.itemView.findViewById<TextView>(R.id.body_text).text = myList[position].body

    }

    fun setData(newList: List<Post>) {
        myList = newList;
        notifyDataSetChanged()
    }
}