package kz.example.zakazssoboi.data.network.worst_code

import kz.example.zakazssoboi.data.network.dto.restaurantDto.RestaurantDetailsDto
import kz.example.zakazssoboi.data.network.dto.restaurantListDto.RestaurantDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroServiceInterface {

    @GET("restaurants")
    suspend fun getCharacters(): List<RestaurantDto>

    @GET("menu/{id}")
    suspend fun getMenuById(@Path("id") id: Int): RestaurantDetailsDto

}