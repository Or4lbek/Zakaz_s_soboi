package kz.example.zakazssoboi.data.network.dto.restaurantListDto


import com.google.gson.annotations.SerializedName

data class Image(
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("restaurant_id")
    val restaurantId: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)