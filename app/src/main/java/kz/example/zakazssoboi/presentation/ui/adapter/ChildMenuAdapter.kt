package kz.example.zakazssoboi.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.databinding.ItemMenuBinding
import kz.example.zakazssoboi.domain.entity.Product
import kz.example.zakazssoboi.presentation.ui.diff_callback.ProductDiffCallBack

class ChildMenuAdapter(private val listener: ChildMenuAdapterListener) :
    ListAdapter<Product, ChildMenuAdapter.CategoryContainerViewHolder>(ProductDiffCallBack()) {

    inner class CategoryContainerViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.minusBtn.setOnClickListener {
                if (binding.counts.text.toString().toInt() > 0) {
                    binding.counts.text = binding.counts.text.toString().toInt().minus(1).toString()
                    listener.onClickMinus(
                        currentList[absoluteAdapterPosition]
                    )
                }

            }
            binding.plusBtn.setOnClickListener {
                binding.counts.text = binding.counts.text.toString().toInt().plus(1).toString()
                listener.onClickPlus(
                    currentList[absoluteAdapterPosition]
                )
            }
        }

        fun bind(item: Product) {
            binding.counts.text = item.counter.toString()
            binding.name.text = item.name
            binding.price.text = item.getPriceAsString()
            Picasso.get().load(item.image).placeholder(R.drawable.back)
                .error(R.drawable.back).into(binding.imageViewMenuMealImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryContainerViewHolder {
        val binding =
            ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryContainerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryContainerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    interface ChildMenuAdapterListener {
        fun onClickPlus(meal: Product)
        fun onClickMinus(meal: Product)
    }
}