package kz.example.zakazssoboi.presentation.view_model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kz.example.zakazssoboi.domain.entity.Product

class BasketViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    val products: Array<Product> = savedStateHandle.get("products") ?: arrayOf()
    val restaurantName = savedStateHandle.get("restaurantName") ?: ""
    val restaurantAddress = savedStateHandle.get("restaurantAddress") ?: ""
    private var selectedProducts: ArrayList<Product> = products.toCollection(ArrayList())

    var totalPrice = 0

    init {
        for (product in selectedProducts) {
            totalPrice += product.price * product.counter
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
}