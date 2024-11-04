package com.mini4wd.egypt.presentation.racers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mini4wd.egypt.R
import com.mini4wd.egypt.databinding.FragmentRacersBinding
import com.mini4wd.egypt.presentation.racers.RacersState.Clear
import com.mini4wd.egypt.presentation.racers.RacersState.Empty
import com.mini4wd.egypt.presentation.racers.RacersState.Error
import com.mini4wd.egypt.presentation.racers.RacersState.Idle
import com.mini4wd.egypt.presentation.racers.RacersState.Loading
import com.mini4wd.egypt.presentation.racers.RacersState.RacersLoaded
import com.mini4wd.egypt.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RacersFragment:Fragment(R.layout.fragment_racers) {
//  private val binding by viewBinding(FragmentRacersBinding::bind)
  private  lateinit var binding: FragmentRacersBinding
  private val viewModel: RacersViewModel by viewModels()
  private val racersAdapter by lazy { RacersAdapter() }
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = FragmentRacersBinding.bind(view)
    lifecycleScope.launch {
      viewModel.userIntent.send(RacersIntent.LoadRacers)
    }
    binding.racersRecyclerView.adapter = racersAdapter
    handleState()
  }
  private fun handleState(){
    lifecycleScope.launch {
      viewModel.state.collect{
        when(it){
          Clear -> {

          }
          Empty -> {

          }
          is Error -> {

          }
          Idle -> {}
          Loading -> { }
          is RacersLoaded -> {
            racersAdapter.submitList(it.racers)
          }
        }
      }
    }
  }

}