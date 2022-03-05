package kz.example.zakazssoboi.data.network.api

import kz.example.zakazssoboi.data.network.dto.restaurantDto.RestaurantDetailsDto
import kz.example.zakazssoboi.data.network.dto.restaurantListDto.RestaurantDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApi {

    @GET("/api/restaurants")
    suspend fun getRestaurantList(): List<RestaurantDto>

    @GET("/api/menu/{id}")
    suspend fun getRestaurant(@Path("id") restaurantId: Int): RestaurantDetailsDto
}