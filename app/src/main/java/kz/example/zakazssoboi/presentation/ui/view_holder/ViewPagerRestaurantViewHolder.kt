package kz.example.zakazssoboi.presentation.ui.view_holder

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.databinding.ItemRestaurantViewPagerBinding

class ViewPagerRestaurantViewHolder(private val binding: ItemRestaurantViewPagerBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) = with(binding) {
        Picasso.get().load(item).placeholder(R.drawable.back)
            .error(R.drawable.back).into(imageViewRestaurantViewPager)
    }
}