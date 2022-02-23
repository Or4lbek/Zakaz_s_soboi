package kz.example.zakazssoboi.presentation.ui.view_holder

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.databinding.ItemCategoryBinding
import kz.example.zakazssoboi.domain.entity.Category

class CategoryViewHolder(private val binding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(category: Category) {
        binding.name.text = category.name
    }

    fun defaultCardStroke(ownBinding: ItemCategoryBinding = binding) {
        ownBinding.name.setTextColor(
            ContextCompat.getColor(
                binding.root.context,
                R.color.graySecond
            )
        )
        ownBinding.root.setCardBackgroundColor(Color.WHITE)
    }

    fun selectedCardStroke() {
        binding.root.setCardBackgroundColor(
            ContextCompat.getColor(
                binding.root.context,
                R.color.gray
            )
        )
    }
}