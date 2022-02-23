package kz.example.zakazssoboi.presentation.ui.view_holder

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kz.example.zakazssoboi.R
import kz.example.zakazssoboi.databinding.ItemRestaurantBinding
import kz.example.zakazssoboi.domain.entity.Restaurant

class RestaurantItemViewHolder(
    private val binding: ItemRestaurantBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind(item: Restaurant) = with(binding){
        textViewRestaurantName.text = item.name
        textViewRestaurantAddress.text = item.address
        Picasso.get().load(item.image).placeholder(R.drawable.back)
            .error(R.drawable.back).into(imageViewRestaurant)
        itemView.startAnimation(
            AnimationUtils.loadAnimation(
                root.context,
                R.anim.recycler_view_animation
            )
        )
    }
}