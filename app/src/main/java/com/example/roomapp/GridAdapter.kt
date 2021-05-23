package com.example.roomapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grid_layout.view.*


class GridAdapter(val context: Context, val arrayList: ArrayList<GridModel>) : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(gridModel: GridModel) {
            itemView.icons_text.text = gridModel.title
            itemView.icons_image.setImageResource(gridModel.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {
            val gridModel = arrayList.get(position)

            var gTitle : String = gridModel.title

            val intent = Intent(context, ContactActivity::class.java)

            intent.putExtra("iTitle", gTitle)
            context.startActivity(intent)
        }
    }


}