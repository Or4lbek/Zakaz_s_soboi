package kz.example.zakazssoboi.data.network.api

import kz.example.zakazssoboi.data.network.dto.restaurantDto.RestaurantDetailsDto
import kz.example.zakazssoboi.data.network.dto.restaurantListDto.RestaurantDto
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantApi {

    @GET("/api/restaurants")
    suspend fun getRestaurantList():Response<List<RestaurantDto>>

    @GET("/api/restaurants")
    suspend fun getRestaurant():Response<RestaurantDetailsDto>
}