package kz.example.zakazssoboi.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.databinding.ItemProductBinding
import kz.example.zakazssoboi.domain.entity.Product
import kz.example.zakazssoboi.presentation.ui.diff_callback.ProductDiffCallBack

class ChildMenuAdapter(private val listener: ChildMenuAdapterListener) :
    ListAdapter<Product, ChildMenuAdapter.CategoryContainerViewHolder>(ProductDiffCallBack()) {

    inner class CategoryContainerViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.apply {
                buttonMinus.setOnClickListener {
                    if (textViewProductCount.text.toString().toInt() > 0) {
                        textViewProductCount.text =
                            textViewProductCount.text.toString().toInt().minus(1).toString()
                        listener.onClickMinus(
                            currentList[absoluteAdapterPosition]
                        )
                        hideMinusButton()
                    }
                }
                buttonPlus.setOnClickListener {
                    textViewProductCount.text =
                        textViewProductCount.text.toString().toInt().plus(1).toString()
                    listener.onClickPlus(
                        currentList[absoluteAdapterPosition]
                    )
                    cartContainer.visibility = View.VISIBLE
                }
            }
        }

        private fun hideMinusButton() = with(binding) {
            if (textViewProductCount.text == "0") {
                cartContainer.visibility = View.GONE
            }
        }

        fun bind(item: Product) = with(binding) {
            textViewProductCount.text = item.counter.toString()
            textViewProductName.text = item.name
            textViewProductPrice.text = item.getPriceAsString()
            Picasso.get().load(item.image).placeholder(R.drawable.back)
                .error(R.drawable.back).into(imageViewProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryContainerViewHolder {
        val binding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryContainerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryContainerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    interface ChildMenuAdapterListener {
        fun onClickPlus(product: Product)
        fun onClickMinus(product: Product)
    }
}