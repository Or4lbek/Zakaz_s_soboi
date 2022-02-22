package kz.example.zakazssoboi.data.network.dto.restaurantListDto


import com.google.gson.annotations.SerializedName

data class RestaurantInfo(
    @SerializedName("restaurant_data")
    val restaurantData: RestaurantData,
    val image: Image
)