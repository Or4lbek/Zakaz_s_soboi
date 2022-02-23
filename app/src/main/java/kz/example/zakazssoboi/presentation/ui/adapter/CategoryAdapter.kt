package kz.example.zakazssoboi.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kz.example.zakazssoboi.databinding.ItemCategoryBinding
import kz.example.zakazssoboi.domain.entity.Category
import kz.example.zakazssoboi.presentation.ui.diff_callback.CategoryDiffCallback
import kz.example.zakazssoboi.presentation.ui.view_holder.CategoryViewHolder

class CategoryAdapter(private val onClickCategory: (Int) -> Unit) :
    ListAdapter<Category, CategoryViewHolder>(CategoryDiffCallback()) {

    private var selectedItemPos = -1
    private var lastItemSelectedPos = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val item = currentList[position]
        holder.itemView.setOnClickListener { onClickCategory(position) }

        if (item.isCurrent) {
            holder.selectedCardStroke()
            lastItemSelectedPos = position
        } else
            holder.defaultCardStroke()
        holder.bind(item)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            when (payloads[0]) {
                2 -> {
                    currentList[position].isCurrent = false
                }
            }
        }
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun selectItem(pos: Int) {
        if (selectedItemPos != -1)
            currentList[selectedItemPos].isCurrent = false
        currentList[pos].isCurrent = true
        selectedItemPos = pos
        notifyDataSetChanged()
    }
}