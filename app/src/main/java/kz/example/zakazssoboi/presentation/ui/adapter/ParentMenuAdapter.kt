package kz.example.zakazssoboi.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.example.zakazssoboi.common.MarginItemDecoration
import kz.example.zakazssoboi.databinding.ItemParentMenuBinding
import kz.example.zakazssoboi.domain.entity.CategoryProduct
import kz.example.zakazssoboi.presentation.ui.diff_callback.CategoryProductDiffCallback


class ParentMenuAdapter(private val listener: ChildMenuAdapter.ChildMenuAdapterListener) :
    ListAdapter<CategoryProduct, ParentMenuAdapter.CategoryContainerViewHolder>(
        CategoryProductDiffCallback()
    ) {

    inner class CategoryContainerViewHolder(private val binding: ItemParentMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.mealRv.addItemDecoration(
                MarginItemDecoration(
                    binding.root.context,
                    LinearLayoutManager.VERTICAL,
                    20
                )
            )
        }

        fun bind(item: CategoryProduct) {
            binding.category.text = item.category
            binding.mealRv.isNestedScrollingEnabled = false
            binding.mealRv.adapter = ChildMenuAdapter(listener).apply {
                submitList(item.meals)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryContainerViewHolder {
        val binding =
            ItemParentMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryContainerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryContainerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}