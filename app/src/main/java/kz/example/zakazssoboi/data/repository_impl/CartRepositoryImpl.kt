package kz.example.zakazssoboi.data.repository_impl

import kz.example.zakazssoboi.domain.entity.Cart
import kz.example.zakazssoboi.domain.repository.CartRepository

class CartRepositoryImpl:CartRepository {
    override suspend fun addToCart(productId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFromCart(productId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun makeOrder(cart: Cart) {
        TODO("Not yet implemented")
    }
}