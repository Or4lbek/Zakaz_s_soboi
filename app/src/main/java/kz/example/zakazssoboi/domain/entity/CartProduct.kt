package kz.example.zakazssoboi.domain.entity

data class CartProduct(
    val productId: Int,
    var count: Int,
    val name:String,
    val price: Int,
    val image: String
)
