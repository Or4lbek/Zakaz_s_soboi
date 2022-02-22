package kz.example.zakazssoboi.data.network.dto.restaurantListDto


import com.google.gson.annotations.SerializedName

data class RestaurantData(
    val id: Int,
    val name: String,
    val location: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("restaurant_images")
    val restaurantImages: List<RestaurantImage>
)