package kz.example.zakazssoboi.presentation.ui.diff_callback

import androidx.recyclerview.widget.DiffUtil
import kz.example.zakazssoboi.domain.entity.Restaurant

class RestaurantDiffCallBack : DiffUtil.ItemCallback<Restaurant>() {
    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem == newItem
    }
}