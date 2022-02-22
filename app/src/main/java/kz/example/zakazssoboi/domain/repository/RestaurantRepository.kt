package kz.example.zakazssoboi.domain.repository

import kz.example.zakazssoboi.domain.entity.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurantList(): List<Restaurant>

    suspend fun getRestaurant(): Restaurant
}