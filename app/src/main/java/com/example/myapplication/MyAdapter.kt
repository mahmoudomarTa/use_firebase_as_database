package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*


class MyAdapter(private var informations: ArrayList<Info>) :RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_layout, viewGroup, false)
        )
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, i: Int) {

        myViewHolder.name.text = informations[i].name
        myViewHolder.address.text = informations[i].address
        myViewHolder.phone.text = informations[i].mobile
    }

    override fun getItemCount(): Int {
        return informations.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var address: TextView
        var phone: TextView

        init {
            name = itemView.nameTv
            address = itemView.tvAddress
            phone = itemView.tvPhone
        }
    }

}