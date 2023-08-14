package com.example.starwarstest.View.FavoritesFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstest.FavoriteApplication
import com.example.starwarstest.Models.data.FavoritesPeople
import com.example.starwarstest.Models.data.FavoritesPlanets
import com.example.starwarstest.Models.data.FavoritesStarships
import com.example.starwarstest.ViewModels.FavoriteViewModelFactory
import com.example.starwarstest.ViewModels.FavoritesViewModel
import com.example.starwarstest.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    lateinit var binding: FragmentFavoritesBinding
    lateinit var adapter: FavoriteAdapter<Any?>
    private val viewModel: FavoritesViewModel by viewModels {
        FavoriteViewModelFactory((requireActivity().application as FavoriteApplication).repository)
    }
    private val itemClickListener = object : DeleteItemActionListener {
        override fun onDeleteFavoritePeopleClick(position: Int, item: FavoritesPeople) {
            Toast.makeText(
                requireContext(),
                "Delete from favorites",
                Toast.LENGTH_SHORT
            ).show()
            viewModel.deletePeople(item)
        }

        override fun onDeleteFavoriteStarshipClick(position: Int, item: FavoritesStarships) {
            Toast.makeText(
                requireContext(),
                "Delete from favorites",
                Toast.LENGTH_SHORT
            ).show()
            viewModel.deleteStarship(item)
        }

        override fun onDeleteFavoritePlanetClick(position: Int, item: FavoritesPlanets) {
            Toast.makeText(
                requireContext(),
                "Delete from favorites",
                Toast.LENGTH_SHORT
            ).show()
            viewModel.deletePlanet(item)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initAdapter()
        super.onViewCreated(view, savedInstanceState)
        observers()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllFavorites()
    }

    fun initAdapter() {
        adapter = FavoriteAdapter()
        adapter.setOnItemClickListener(itemClickListener)
        binding.rvFavorites.adapter = adapter
        binding.rvFavorites.layoutManager = LinearLayoutManager(requireContext())

    }

    fun observers() {
        viewModel.allFavorites.observe(viewLifecycleOwner) { item ->
            adapter.updateDataSet(item)
        }
    }
}