package kz.example.zakazssoboi.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kz.example.zakazssoboi.common.Constants.PIZZA_URL
import kz.example.zakazssoboi.domain.entity.CategoryProduct
import kz.example.zakazssoboi.domain.entity.Product

class RestaurantDetailViewModel() : ViewModel() {

    var viewPagerImages: ArrayList<String> = ArrayList()
    val liveData: MutableLiveData<List<CategoryProduct>> = MutableLiveData()
    val selectedProducts: ArrayList<Product> = ArrayList()
    val restaurantAddress = "ул. Панфилова 109"
    val restaurantName = "Mamma mia"
    var totalPrice = 0

    init {
        fetchAllCategories()
        viewPagerImages.apply {
            add("https://media-cdn.tripadvisor.com/media/photo-s/13/c5/15/2f/interiors.jpg")
            add("https://restolife.kz/upload/information_system_6/2/1/4/item_21447/information_items_property_24075.jpg")
            add("https://media-cdn.tripadvisor.com/media/photo-s/0a/58/db/09/mamma-mia.jpg")
            add("https://www.localguidesconnect.com/t5/image/serverpage/image-id/609103i935F61DE5BBBEA81?v=v2")
            add("https://media-cdn.tripadvisor.com/media/photo-s/1a/d2/f1/bd/kfc.jpg")
            add("https://media-cdn.tripadvisor.com/media/photo-s/13/c5/15/2f/interiors.jpg")
        }

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


    private fun fetchAllCategories() {
        val meals1 = Product(
            id = 1,
            name = "Маргаритта",
            image = PIZZA_URL,
            price = 1700,
            description = "23456"
        )

        val meals2 = Product(
            id = 2,
            name = "Маргаритта",
            image = PIZZA_URL,
            price = 1700,
            description = "23456"
        )
        val meals3 = Product(
            id = 3,
            name = "Маргаритта3",
            image = PIZZA_URL,
            price = 1800,
            description = "23456"
        )
        val categoryPizza = CategoryProduct(
            1,
            category = "Пицца",
            products = listOf(
                meals1,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3
            )
        )
        val categoryDrinks = CategoryProduct(
            2,
            category = "Напитки",
            products = listOf(
                meals1,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3
            )
        )
        val categoryFruits = CategoryProduct(
            3,
            category = "Фрукты",
            products = listOf(
                meals1,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3
            )
        )
        val categoryFruits1 = CategoryProduct(
            3,
            category = "Фрукты1",
            products = listOf(
                meals1,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3
            )
        )
        val categoryFruits12 = CategoryProduct(
            3,
            category = "Фрукты12",
            products = listOf(
                meals1,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3
            )
        )
        val categoryFruits13 = CategoryProduct(
            3,
            category = "Фрукты13",
            products = listOf(
                meals1,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3
            )
        )
        val categoryFruits14 = CategoryProduct(
            3,
            category = "Фрукты14",
            products = listOf(
                meals1,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3,
                meals2,
                meals3
            )
        )
        val categoryFruits15 = CategoryProduct(
            3,
            category = "Фрукты15",
            products = listOf(
                meals1
            )
        )

        liveData.postValue(
            listOf(
                categoryPizza,
                categoryFruits,
                categoryDrinks,
                categoryFruits1,
                categoryFruits12,
                categoryFruits13,
                categoryFruits14,
                categoryFruits15
            )
        )
    }
}