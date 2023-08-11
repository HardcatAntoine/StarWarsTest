package com.example.starwarstest.View.SearchFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarstest.FavoriteApplication
import com.example.starwarstest.Models.data.FavoritesPeople
import com.example.starwarstest.Models.data.FavoritesPlanets
import com.example.starwarstest.Models.data.FavoritesStarships
import com.example.starwarstest.Models.data.people.People
import com.example.starwarstest.Models.data.planet.Planet
import com.example.starwarstest.Models.data.starships.Starships
import com.example.starwarstest.ViewModels.SearchFragmentViewModel
import com.example.starwarstest.ViewModels.SearchViewModelFactory
import com.example.starwarstest.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    lateinit var adapter: SearchAdapter<Any?>
    private val viewModel: SearchFragmentViewModel by viewModels {
        SearchViewModelFactory((requireActivity().application as FavoriteApplication).repository)
    }

    private val itemClickListener = object : ItemActionListener {
        override fun onAddFavoritePeopleClick(position: Int, item: People) {
            Toast.makeText(
                requireContext(),
                "Favorite people add",
                Toast.LENGTH_SHORT
            ).show()
            val people = FavoritesPeople(
                name = item.name,
                gender = item.gender,
                starships = item.starships.size
            )
            viewModel.insertPeople(people)
        }

        override fun onAddFavoriteStarshipClick(position: Int, item: Starships) {
            Toast.makeText(
                requireContext(),
                "Favorite starship add",
                Toast.LENGTH_SHORT
            ).show()
            val starships = FavoritesStarships(
                name = item.name,
                model = item.model,
                manufacturer = item.manufacturer,
                passengers = item.passengers
            )
            viewModel.insertStarship(starships)
        }

        override fun onAddFavoritePlanetClick(position: Int, item: Planet) {
            Toast.makeText(
                requireContext(),
                "Favorite planet add",
                Toast.LENGTH_SHORT
            ).show()
            val planets = FavoritesPlanets(
                name = item.name,
                diameter = item.diameter,
                population = item.population
            )
            viewModel.insertPlanet(planets)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchResult(newText!!)
                return true
            }
        })

        chipChecked()
        observers()
    }

    fun observers() {
        viewModel.people.observe(viewLifecycleOwner) { people ->
            adapter.updateDataSet(people)

        }
        viewModel.starships.observe(viewLifecycleOwner) { starship ->
            adapter.updateDataSet(starship)
        }
        viewModel.planet.observe(viewLifecycleOwner) { planets ->
            adapter.updateDataSet(planets)
        }

    }


    fun chipChecked() {
        binding.chipPeople.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) viewModel.setPeopleQueryOptions()
        }
        binding.chipStarship.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) viewModel.setStarshipQueryOptions()
        }
        binding.chipPlanet.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) viewModel.setPlanetQueryOptions()
        }

    }

    fun initAdapter() {
        adapter = SearchAdapter()
        adapter.setOnItemClickListener(itemClickListener)
        binding.rvSearch.adapter = adapter
        binding.rvSearch.layoutManager = LinearLayoutManager(requireContext())
    }

}


