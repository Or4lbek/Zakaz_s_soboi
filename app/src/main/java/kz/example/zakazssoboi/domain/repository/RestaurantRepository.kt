package kz.example.zakazssoboi.domain.repository

import kz.example.zakazssoboi.data.network.dto.restaurantDto.RestaurantDetailsDto
import kz.example.zakazssoboi.data.network.dto.restaurantListDto.RestaurantDto

interface RestaurantRepository {
    suspend fun getRestaurantList(): List<RestaurantDto>

    suspend fun getRestaurant(restaurantId: Int): RestaurantDetailsDto
}