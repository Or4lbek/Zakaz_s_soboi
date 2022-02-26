package kz.example.zakazssoboi.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kz.example.zakazssoboi.databinding.ItemCategoryCountBinding
import kz.example.zakazssoboi.domain.entity.Category
import kz.example.zakazssoboi.presentation.ui.diff_callback.CategoryDiffCallback
import kz.example.zakazssoboi.presentation.ui.view_holder.CategoryMenuViewHolder

class CategoryMenuAdapter(private val onClickCategoryMenu: (Int) -> Unit) :
    ListAdapter<Category, CategoryMenuViewHolder>(CategoryDiffCallback()) {

    override fun onBindViewHolder(holder: CategoryMenuViewHolder, position: Int) {
        val item = currentList[position]
        holder.itemView.setOnClickListener { onClickCategoryMenu(position) }
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMenuViewHolder {
        val binding =
            ItemCategoryCountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryMenuViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}