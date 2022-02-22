package kz.example.zakazssoboi.domain.entity

data class RestaurantDetails(
    val id: Int,
    val name: String,
    val address: String,
    val imageList: List<String>,
    val categoryList: List<Category>
)