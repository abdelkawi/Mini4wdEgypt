package com.mini4wd.egypt.presentation.addracer

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mini4wd.egypt.R
import com.mini4wd.egypt.data.model.Racer
import com.mini4wd.egypt.databinding.FragmentAddRacerBinding
import com.mini4wd.egypt.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddRacer: Fragment(R.layout.fragment_add_racer) {
  private val binding by viewBinding(FragmentAddRacerBinding::bind)
  private val addRacerViewModel:AddRacerViewmodel by viewModels()
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.addButton.setOnClickListener {
      if(validate()){
        lifecycleScope.launch {
        if(  addRacerViewModel.addRacer(Racer(name = binding.nameEditText.text.toString(),
            totalPoints = binding.pointsEditText.text.toString().toInt()))){
          Toast.makeText(requireContext(), "Racer added successfully", Toast.LENGTH_SHORT).show()
          findNavController().navigateUp()
        }else {
          Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
        }
        }
      }
    }
  }
  private fun validate():Boolean{
    if(binding.nameEditText.text.toString().isEmpty()){
      Toast.makeText(requireContext(), "Please enter racer name", Toast.LENGTH_SHORT).show()
      return false
    }
    if(binding.pointsEditText.text.toString().isEmpty()){
      Toast.makeText(requireContext(), "Please enter racer points", Toast.LENGTH_SHORT).show()
      return false
    }
    return true
  }
}