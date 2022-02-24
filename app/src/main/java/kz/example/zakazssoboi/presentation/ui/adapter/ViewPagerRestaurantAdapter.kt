package kz.example.zakazssoboi.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kz.example.zakazssoboi.databinding.ItemRestaurantViewPagerBinding
import kz.example.zakazssoboi.presentation.ui.diff_callback.RestaurantImageDiffCallback
import kz.example.zakazssoboi.presentation.ui.view_holder.ViewPagerRestaurantViewHolder

class ViewPagerRestaurantAdapter() : ListAdapter<String, ViewPagerRestaurantViewHolder>(
    RestaurantImageDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerRestaurantViewHolder {
        val binding = ItemRestaurantViewPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewPagerRestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerRestaurantViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}