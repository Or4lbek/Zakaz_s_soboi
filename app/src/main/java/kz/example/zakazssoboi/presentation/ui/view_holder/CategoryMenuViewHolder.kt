package kz.example.zakazssoboi.presentation.ui.view_holder

import androidx.recyclerview.widget.RecyclerView
import kz.example.zakazssoboi.databinding.ItemCategoryCountBinding
import kz.example.zakazssoboi.domain.entity.CategoryMenu

class CategoryMenuViewHolder(private val binding: ItemCategoryCountBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(category: CategoryMenu) = with(binding) {
        textViewCategoryName.text = category.name
        textViewCategoryProductCount.text = category.count.toString()
    }
}