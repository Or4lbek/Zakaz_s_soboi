package kz.example.zakazssoboi.domain.repository

import kotlinx.coroutines.flow.Flow
import kz.example.zakazssoboi.data.network.dto.restaurantDto.RestaurantDetailsDto
import kz.example.zakazssoboi.data.network.dto.restaurantListDto.RestaurantDto
import kz.example.zakazssoboi.domain.entity.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurantList(): Flow<List<Restaurant>>

    suspend fun getRestaurant(restaurantId: Int): RestaurantDetailsDto
}