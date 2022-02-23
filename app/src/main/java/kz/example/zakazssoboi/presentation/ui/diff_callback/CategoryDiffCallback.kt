package kz.example.zakazssoboi.presentation.ui.diff_callback

import androidx.recyclerview.widget.DiffUtil
import kz.example.zakazssoboi.domain.entity.Category

class CategoryDiffCallback  : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}