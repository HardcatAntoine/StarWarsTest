package com.example.starwarstest.Models.data.people

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.starwarstest.Models.data.FavoritesPeople
import com.example.starwarstest.R
import com.example.starwarstest.View.SearchFragment.ItemActionListener
import com.google.android.material.chip.Chip

class PeopleViewHolder(itemView: View) :
    ViewHolder(itemView) {
    private val name = itemView.findViewById<TextView>(R.id.tvNamePeople)
    private val gender = itemView.findViewById<TextView>(R.id.tvGender)
    private val starships = itemView.findViewById<TextView>(R.id.tvStarships)
    private val chip = itemView.findViewById<Chip>(R.id.chipFavorite)


    fun bind(item: People, position: Int, clickListener: ItemActionListener?) {
        name.text = item.name
        gender.text = item.gender
        starships.text = item.starships.size.toString()
        chip.setOnClickListener {
            clickListener?.onAddFavoritePeopleClick(position, item)
        }
    }

    fun favoriteBind(item: FavoritesPeople) {
        name.text = item.name
        gender.text = item.gender
        starships.text = item.starships.toString()
        chip.isChecked = true
    }
}