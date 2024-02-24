package com.example.workouttracker.adapterRecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workouttracker.R
import com.example.workouttracker.model.Sport

class SportAdapter(
    private var sportList: ArrayList<Sport>
): RecyclerView.Adapter<SportAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvSportName: TextView
        init {
            tvSportName = itemView.findViewById(R.id.tvSportName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_sport, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sport = sportList[position]

        holder.tvSportName.text = sport.sportName
    }

    override fun getItemCount(): Int {
        return sportList.size
    }
}