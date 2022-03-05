package kz.example.zakazssoboi.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.example.zakazssoboi.common.MarginItemDecoration
import kz.example.zakazssoboi.databinding.ItemCategoryProductsBinding
import kz.example.zakazssoboi.domain.entity.Category
import kz.example.zakazssoboi.presentation.ui.diff_callback.CategoryDiffCallback


class ParentMenuAdapter(private val listener: ChildMenuAdapter.ChildMenuAdapterListener) :
    ListAdapter<Category, ParentMenuAdapter.CategoryContainerViewHolder>(
        CategoryDiffCallback()
    ) {

    inner class CategoryContainerViewHolder(private val binding: ItemCategoryProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.recyclerViewProducts.addItemDecoration(
                MarginItemDecoration(
                    binding.root.context,
                    LinearLayoutManager.VERTICAL,
                    20
                )
            )
        }

        fun bind(item: Category) = with(binding) {
            textViewCategoryName.text = item.name
            recyclerViewProducts.isNestedScrollingEnabled = false
            recyclerViewProducts.adapter = ChildMenuAdapter(listener).apply {
                submitList(item.productList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryContainerViewHolder {
        val binding =
            ItemCategoryProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryContainerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryContainerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}