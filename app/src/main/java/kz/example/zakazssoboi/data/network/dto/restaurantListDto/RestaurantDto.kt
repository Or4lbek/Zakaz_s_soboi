package kz.example.zakazssoboi.data.network.dto.restaurantListDto


import com.google.gson.annotations.SerializedName
import kz.example.zakazssoboi.domain.entity.Restaurant

data class RestaurantDto(
    @SerializedName("restaurant")
    val restaurantInfo: RestaurantInfo
)

fun RestaurantDto.toRestaurant(): Restaurant {
    return Restaurant(
        id = restaurantInfo.restaurantData.id,
        name = restaurantInfo.restaurantData.name,
        address = restaurantInfo.restaurantData.location,
        image = restaurantInfo.image.imageUrl
    )
}