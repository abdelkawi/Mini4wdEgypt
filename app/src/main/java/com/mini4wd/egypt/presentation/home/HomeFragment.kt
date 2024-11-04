package com.mini4wd.egypt.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mini4wd.egypt.R
import com.mini4wd.egypt.databinding.FragmentHomeBinding
import com.mini4wd.egypt.utils.viewBinding

class HomeFragment :Fragment(R.layout.fragment_home) {
  private val binding by viewBinding(FragmentHomeBinding::bind)
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.racesTv.setOnClickListener {
      findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRacesFragment())
    }
    binding.carsTv.setOnClickListener {
      findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCarsFragment())
    }
    binding.racersTv.setOnClickListener {
      findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRacersFragment())
    }
    binding.roundsTv.setOnClickListener {
      findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRoundsFragment())
    }
  }
}