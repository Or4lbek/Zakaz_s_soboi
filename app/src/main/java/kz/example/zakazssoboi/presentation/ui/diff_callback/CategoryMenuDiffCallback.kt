package kz.example.zakazssoboi.presentation.ui.diff_callback

import androidx.recyclerview.widget.DiffUtil
import kz.example.zakazssoboi.domain.entity.CategoryMenu

class CategoryMenuDiffCallback : DiffUtil.ItemCallback<CategoryMenu>() {
    override fun areItemsTheSame(oldItem: CategoryMenu, newItem: CategoryMenu): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryMenu, newItem: CategoryMenu): Boolean {
        return oldItem == newItem
    }
}