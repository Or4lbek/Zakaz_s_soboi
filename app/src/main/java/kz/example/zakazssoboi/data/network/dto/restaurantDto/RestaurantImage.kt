package kz.example.zakazssoboi.data.network.dto.restaurantDto


import com.google.gson.annotations.SerializedName

data class RestaurantImage(
    @SerializedName("image_id")
    val imageId: Int,
    val url: String
)