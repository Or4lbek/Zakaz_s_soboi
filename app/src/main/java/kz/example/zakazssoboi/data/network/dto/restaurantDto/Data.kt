package kz.example.zakazssoboi.data.network.dto.restaurantDto


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("restaurant_id")
    val restaurantId: Int,
    @SerializedName("restaurant_name")
    val restaurantName: String,
    val location: String,
    @SerializedName("restaurant_images")
    val restaurantImages: List<RestaurantImage>,
    @SerializedName("product_categories")
    val productCategories: List<ProductCategory>
)