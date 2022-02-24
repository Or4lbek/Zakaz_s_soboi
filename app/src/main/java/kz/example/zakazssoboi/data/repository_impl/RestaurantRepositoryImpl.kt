package kz.example.zakazssoboi.data.repository_impl

import kz.example.zakazssoboi.data.network.api.RestaurantApi
import kz.example.zakazssoboi.data.network.dto.restaurantDto.RestaurantDetailsDto
import kz.example.zakazssoboi.data.network.dto.restaurantListDto.RestaurantDto
import kz.example.zakazssoboi.domain.entity.Restaurant
import kz.example.zakazssoboi.domain.repository.RestaurantRepository
import javax.inject.Inject

class RestaurantRepositoryImpl @Inject constructor(
    private val api: RestaurantApi
) : RestaurantRepository {
    override suspend fun getRestaurantList(): List<RestaurantDto> {
        return api.getRestaurantList()
    }

    override suspend fun getRestaurant(restaurantId: Int): RestaurantDetailsDto {
        return api.getRestaurant(restaurantId)
    }
}