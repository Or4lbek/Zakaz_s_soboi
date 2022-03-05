package kz.example.zakazssoboi.domain.repository

import kz.example.zakazssoboi.domain.entity.Cart

interface CartRepository {
    suspend fun addToCart(productId: Int)

    suspend fun removeFromCart(productId: Int)

    suspend fun makeOrder(cart: Cart)
}