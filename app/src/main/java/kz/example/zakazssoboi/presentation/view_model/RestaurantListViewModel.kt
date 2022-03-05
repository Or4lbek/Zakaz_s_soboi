package kz.example.zakazssoboi.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.example.zakazssoboi.data.network.dto.restaurantListDto.RestaurantDto
import kz.example.zakazssoboi.data.network.dto.restaurantListDto.toRestaurant
import kz.example.zakazssoboi.data.network.worst_code.RetroInstance
import kz.example.zakazssoboi.data.network.worst_code.RetroServiceInterface
import kz.example.zakazssoboi.domain.entity.Restaurant

class RestaurantListViewModel : ViewModel() {

    private val liveDataRestaurantListMutable: MutableLiveData<List<Restaurant>> =
        MutableLiveData()
    val liveDataRestaurantList: LiveData<List<Restaurant>> = liveDataRestaurantListMutable

    init {
        fetchRestaurantListApi()
    }

    private fun fetchRestaurantListApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetrofitInstance()
            val retroService = retroInstance.create(RetroServiceInterface::class.java)
            val call = retroService.getCharacters()
            liveDataRestaurantListMutable.postValue(fromRestaurantDtoToRestaurant(call))
        }
    }

    private fun fromRestaurantDtoToRestaurant(restaurantDtoList: List<RestaurantDto>): List<Restaurant> {
        val restaurantList: ArrayList<Restaurant> = ArrayList()
        restaurantDtoList.map {
            restaurantList.add(it.toRestaurant())
        }
        return restaurantList
    }
}