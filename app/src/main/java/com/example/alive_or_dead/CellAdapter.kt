package com.example.alive_or_dead

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CellAdapter(private val dataSet: ArrayList<Cell>) :
    RecyclerView.Adapter<CellAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val comment: TextView
        val image: ImageView

        init {
            // Define click listener for the ViewHolder's View
            name = view.findViewById(R.id.name)
            comment = view.findViewById(R.id.comment)
            image = view.findViewById(R.id.image)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.name.text = dataSet[position].name
        viewHolder.comment.text = dataSet[position].comment
        if (dataSet[position].image == "dead")
            viewHolder.image.setImageResource(R.drawable.dead)
        else if (dataSet[position].image == "alive")
            viewHolder.image.setImageResource(R.drawable.alive)
        else if (dataSet[position].image == "skull")
            viewHolder.image.setImageResource(R.drawable.skull)
        else
            viewHolder.image.setImageResource(R.drawable.life)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}