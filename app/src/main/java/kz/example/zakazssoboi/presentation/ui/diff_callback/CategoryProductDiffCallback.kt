package kz.example.zakazssoboi.presentation.ui.diff_callback

import androidx.recyclerview.widget.DiffUtil
import kz.example.zakazssoboi.domain.entity.CategoryProduct

class CategoryProductDiffCallback : DiffUtil.ItemCallback<CategoryProduct>() {
    override fun areItemsTheSame(oldItem: CategoryProduct, newItem: CategoryProduct): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryProduct, newItem: CategoryProduct): Boolean {
        return oldItem == newItem
    }
}