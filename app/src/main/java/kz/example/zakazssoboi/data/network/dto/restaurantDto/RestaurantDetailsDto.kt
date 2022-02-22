package kz.example.zakazssoboi.data.network.dto.restaurantDto


import kz.example.zakazssoboi.domain.entity.RestaurantDetails

data class RestaurantDetailsDto(
    val data: Data
)

fun RestaurantDetailsDto.toRestaurantDetails(): RestaurantDetails {
    return RestaurantDetails(
        id = data.restaurantId,
        name = data.restaurantName,
        address = data.location,
        imageList = data.restaurantImages.map { it.url },
        categoryList = data.productCategories.map {
            it.toCategory()
        }
    )
}