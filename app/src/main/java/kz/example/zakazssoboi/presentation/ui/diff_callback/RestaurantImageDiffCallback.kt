package kz.example.zakazssoboi.presentation.ui.diff_callback

import androidx.recyclerview.widget.DiffUtil
import kz.example.zakazssoboi.domain.entity.Category

class RestaurantImageDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}