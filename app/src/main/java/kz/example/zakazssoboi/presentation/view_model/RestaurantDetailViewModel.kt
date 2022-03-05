package kz.example.zakazssoboi.presentation.view_model

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.example.zakazssoboi.data.network.dto.restaurantDto.RestaurantDetailsDto
import kz.example.zakazssoboi.data.network.dto.restaurantDto.toCategory
import kz.example.zakazssoboi.data.network.worst_code.RetroInstance
import kz.example.zakazssoboi.data.network.worst_code.RetroServiceInterface
import kz.example.zakazssoboi.domain.entity.Category
import kz.example.zakazssoboi.domain.entity.Product

class RestaurantDetailViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private var liveDataRestaurantMutable: MutableLiveData<RestaurantDetailsDto> = MutableLiveData()
    private var liveDataViewPagerImagesMutable: MutableLiveData<List<String>> = MutableLiveData()
    private var liveDataCategoriesListMutable: MutableLiveData<List<Category>> = MutableLiveData()

    val liveDataCategoriesList: LiveData<List<Category>> = liveDataCategoriesListMutable
    val liveDataViewPagerImages: LiveData<List<String>> = liveDataViewPagerImagesMutable
    val liveDataRestaurant: LiveData<RestaurantDetailsDto> = liveDataRestaurantMutable

    val id: Int = savedStateHandle["id"] ?: 1
    val selectedProducts: ArrayList<Product> = ArrayList()

    var totalPrice = 0


    init {
        fetchMenuApi()
    }

    private fun fetchMenuApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetrofitInstance()
            val retroService = retroInstance.create(RetroServiceInterface::class.java)
            val call = retroService.getMenuById(id)
            liveDataRestaurantMutable.postValue(call)
            init()
        }
    }

    private fun init() {
        val categoryList = fromRestaurantDetailsDtoToCategory(
            liveDataRestaurantMutable.value
        )
        liveDataCategoriesListMutable.postValue(
            categoryList
        )
        liveDataViewPagerImagesMutable.postValue(fromMenuDTOtoImages(liveDataRestaurantMutable.value))

    }


    fun addProduct(product: Product) {
        totalPrice += product.price
        if (!selectedProducts.contains(product))
            selectedProducts.add(product)
        product.counter++
    }

    fun removeProduct(product: Product) {
        totalPrice -= product.price
        product.counter--
        if (selectedProducts.contains(product) && product.counter <= 0)
            selectedProducts.remove(product)
    }

    fun getSelectedProductsCount(): String {
        var count = 0
        selectedProducts.forEach {
            count += it.counter
        }
        return count.toString()
    }

    private fun fromRestaurantDetailsDtoToCategory(restaurantDtoList: RestaurantDetailsDto?): List<Category> {
        val categoryList: ArrayList<Category> = ArrayList()
        restaurantDtoList?.data?.productCategories?.map {
            categoryList.add(it.toCategory())
        }
        return categoryList
    }

    private fun fromMenuDTOtoImages(restaurantDtoList: RestaurantDetailsDto?): List<String> {
        val imageList: ArrayList<String> = ArrayList()
        restaurantDtoList?.data?.restaurantImages?.map {
            imageList.add(it.url)
        }
        return imageList.toList()
    }
}