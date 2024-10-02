package com.example.alive_or_dead

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CellAdapter(private val dataSet: ArrayList<Cell>) :
    RecyclerView.Adapter<CellAdapter.ViewHolder>() {

    // Привязка ViewHolder к объектам
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val comment: TextView
        val image: ImageView

        init {
            name = view.findViewById(R.id.name)
            comment = view.findViewById(R.id.comment)
            image = view.findViewById(R.id.image)
        }
    }

    // Создание ViewHolder
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Установка данных
        viewHolder.name.text = dataSet[position].name
        viewHolder.comment.text = dataSet[position].comment
        when (dataSet[position].image) {
            "dead" -> viewHolder.image.setImageResource(R.drawable.dead)
            "alive" -> viewHolder.image.setImageResource(R.drawable.alive)
            "skull" -> viewHolder.image.setImageResource(R.drawable.skull)
            else -> viewHolder.image.setImageResource(R.drawable.life)
        }
    }

    override fun getItemCount() = dataSet.size
}