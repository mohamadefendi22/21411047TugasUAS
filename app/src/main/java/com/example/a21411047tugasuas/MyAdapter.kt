package com.example.a21411047tugasuas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.ParsePosition

class MyAdapter(private val namaList: ArrayList<ItemData>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick (position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class MyViewHolder (itemData: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemData) {
        val gambar:ImageView = itemData.findViewById(R.id.gambar)
        val nama:TextView = itemData.findViewById(R.id.nama)
        val berkuasa:TextView = itemData.findViewById(R.id.berkuasa)
        val kesultanan:TextView = itemData.findViewById(R.id.kesultanan)

        init {
            itemView.setOnClickListener{
               listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemData=LayoutInflater.from(parent.context).inflate(R.layout.example_item,parent,false)
        return MyViewHolder(itemData, mListener)
    }

    override fun getItemCount(): Int = namaList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.berkuasa.text = currentItem.berkuasa
        holder.kesultanan.text = currentItem.kesultanan
    }
}