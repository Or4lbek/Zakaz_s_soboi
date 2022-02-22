package kz.example.zakazssoboi.data.repository_impl

import kz.example.zakazssoboi.domain.entity.Restaurant
import kz.example.zakazssoboi.domain.repository.RestaurantRepository

class RestaurantRepositoryImpl : RestaurantRepository {
    override suspend fun getRestaurantList(): List<Restaurant> {
        TODO("Not yet implemented")
    }

    override suspend fun getRestaurant(): Restaurant {
        TODO("Not yet implemented")
    }
}