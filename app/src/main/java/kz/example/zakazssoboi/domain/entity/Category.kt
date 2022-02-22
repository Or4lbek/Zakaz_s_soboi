package kz.example.zakazssoboi.domain.entity

data class Category(
    val id: Int,
    val name: String,
    val productList: List<Product>,
    var isCurrent: Boolean
)
