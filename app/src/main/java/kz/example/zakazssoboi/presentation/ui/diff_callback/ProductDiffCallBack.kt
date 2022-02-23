package kz.example.zakazssoboi.presentation.ui.diff_callback

import androidx.recyclerview.widget.DiffUtil
import kz.example.zakazssoboi.domain.entity.Product

class ProductDiffCallBack : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}