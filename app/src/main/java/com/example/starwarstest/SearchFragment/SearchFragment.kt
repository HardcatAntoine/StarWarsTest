package com.example.starwarstest.SearchFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starwarstest.R
import com.example.starwarstest.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun chipListeners() {
        binding.chipPeople.setOnClickListener {
            // Responds to chip click
        }

        binding.chipPeople.setOnCloseIconClickListener {
            // Responds to chip's close icon click if one is present
        }

        binding.chipPeople.setOnCheckedChangeListener { chip, isChecked ->
            // Responds to chip checked/unchecked
        }
        binding.chipStarships.setOnClickListener {
            // Responds to chip click
        }

        binding.chipStarships.setOnCloseIconClickListener {
            // Responds to chip's close icon click if one is present
        }

        binding.chipStarships.setOnCheckedChangeListener { chip, isChecked ->
            // Responds to chip checked/unchecked
        }

    }
}