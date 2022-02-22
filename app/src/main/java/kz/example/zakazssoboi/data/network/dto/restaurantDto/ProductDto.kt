package kz.example.zakazssoboi.data.network.dto.restaurantDto


import com.google.gson.annotations.SerializedName
import kz.example.zakazssoboi.domain.entity.Product

data class ProductDto(
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("product_name")
    val productName: String,
    val price: Int,
    val description: String,
    val image: String
)

fun ProductDto.toProduct(): Product {
    return Product(
        id = productId,
        name = productName,
        description = description,
        image = image,
        price = price
    )
}