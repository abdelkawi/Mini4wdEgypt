package com.mini4wd.egypt.presentation.racers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mini4wd.egypt.data.model.Racer
import com.mini4wd.egypt.databinding.ItemRacerBinding

class RacersAdapter : ListAdapter<Racer,RacerViewHolder>(DiffCallback) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RacerViewHolder {
    val binding = ItemRacerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    return RacerViewHolder(binding)
  }

  override fun onBindViewHolder(holder: RacerViewHolder, position: Int) {
    holder.bind(getItem(position))
  }
}
object DiffCallback : DiffUtil.ItemCallback<Racer>() {
  override fun areItemsTheSame(p0: Racer, p1: Racer): Boolean {
    return p1.id == p0.id
  }

  override fun areContentsTheSame(p0: Racer, p1: Racer): Boolean {
    return p1.id == p0.id
  }

}
class RacerViewHolder(val binding : ItemRacerBinding) : RecyclerView.ViewHolder(binding.root) {
  fun bind(racer: Racer) {
    binding.racerName.text =racer.name
    "${racer.totalPoints} points ".also { binding.totalPoints.text = it }
  }
}