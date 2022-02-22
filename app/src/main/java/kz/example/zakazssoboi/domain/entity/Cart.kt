package kz.example.zakazssoboi.domain.entity

data class Cart(
    val restaurantId: Int,
    val restaurantName: String,
    val restaurantAddress: String,
    var productList: List<CartProduct>
)