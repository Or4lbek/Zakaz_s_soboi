package kz.example.zakazssoboi.domain.entity

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val price: Int,
    var counter: Int = 0
) {
    fun getPriceAsString(): String {
        return "$price тг"
    }
}

