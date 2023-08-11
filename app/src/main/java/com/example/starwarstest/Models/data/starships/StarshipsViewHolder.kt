package com.example.starwarstest.Models.data.starships

import android.content.DialogInterface.OnClickListener
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.starwarstest.Models.data.FavoritesStarships
import com.example.starwarstest.R
import com.example.starwarstest.View.SearchFragment.ItemActionListener
import com.google.android.material.chip.Chip
import java.text.FieldPosition

class StarshipsViewHolder(itemView: View ) :
    ViewHolder(itemView) {
    private val name = itemView.findViewById<TextView>(R.id.tvStarshipName)
    private val model = itemView.findViewById<TextView>(R.id.tvStarshipModel)
    private val manufacturer = itemView.findViewById<TextView>(R.id.tvManufacturer)
    private val passengers = itemView.findViewById<TextView>(R.id.tvPassengers)
    private val chip = itemView.findViewById<Chip>(R.id.chipFavorite)

    fun bind(item: Starships, position: Int, clickListener: ItemActionListener?) {
        name.text = item.name
        model.text = item.model
        manufacturer.text = item.manufacturer
        passengers.text = item.passengers
        chip.setOnClickListener {
            clickListener?.onAddFavoriteStarshipClick(position, item)
        }
    }

    fun favoriteBind(item: FavoritesStarships) {
        name.text = item.name
        model.text = item.model
        manufacturer.text = item.manufacturer
        passengers.text = item.passengers
        chip.isChecked = true
    }
}