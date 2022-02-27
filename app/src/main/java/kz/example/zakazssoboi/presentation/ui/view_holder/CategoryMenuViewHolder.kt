package kz.example.zakazssoboi.presentation.ui.view_holder

import androidx.recyclerview.widget.RecyclerView
import kz.example.zakazssoboi.databinding.ItemCategoryCountBinding
import kz.example.zakazssoboi.domain.entity.Category

class CategoryMenuViewHolder(val binding: ItemCategoryCountBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(category: Category) = with(binding) {
        textViewCategoryName.text = category.name
        textViewCategoryProductCount.text = category.productList.count().toString()
    }
}