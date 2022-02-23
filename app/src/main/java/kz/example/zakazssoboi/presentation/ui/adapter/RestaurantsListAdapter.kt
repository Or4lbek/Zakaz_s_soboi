package kz.example.zakazssoboi.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kz.example.zakazssoboi.databinding.ItemRestaurantBinding
import kz.example.zakazssoboi.domain.entity.Restaurant
import kz.example.zakazssoboi.presentation.ui.diff_callback.RestaurantDiffCallBack
import kz.example.zakazssoboi.presentation.ui.view_holder.RestaurantItemViewHolder

class RestaurantsListAdapter(
    val clickListener: (item: Restaurant) -> Unit
) : ListAdapter<Restaurant, RestaurantItemViewHolder>(
    RestaurantDiffCallBack()
) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantItemViewHolder {
        val binding = ItemRestaurantBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RestaurantItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantItemViewHolder, position: Int) {
        val item: Restaurant = currentList[position]
        holder.itemView.setOnClickListener { clickListener(item) }
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

}