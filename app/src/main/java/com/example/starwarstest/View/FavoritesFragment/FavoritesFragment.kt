package com.example.starwarstest.View.FavoritesFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstest.FavoriteApplication
import com.example.starwarstest.ViewModels.FavoriteViewModelFactory
import com.example.starwarstest.ViewModels.FavoritesViewModel
import com.example.starwarstest.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    lateinit var binding: FragmentFavoritesBinding
    lateinit var adapter: FavoriteAdapter<Any?>
    private val viewModel: FavoritesViewModel by viewModels {
        FavoriteViewModelFactory((requireActivity().application as FavoriteApplication).repository)
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
        binding.rvFavorites.adapter = adapter
        binding.rvFavorites.layoutManager = LinearLayoutManager(requireContext())

    }

    fun observers() {
        viewModel.allFavorites.observe(viewLifecycleOwner) { item ->
            adapter.updateDataSet(item)
        }
    }
}