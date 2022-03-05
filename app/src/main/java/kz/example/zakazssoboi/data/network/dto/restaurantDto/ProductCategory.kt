package kz.example.zakazssoboi.data.network.dto.restaurantDto


import com.google.gson.annotations.SerializedName
import kz.example.zakazssoboi.domain.entity.Category

data class ProductCategory(
    @SerializedName("product_category_id")
    val productCategoryId: Int,
    @SerializedName("product_category_name")
    val productCategoryName: String,
    @SerializedName("products")
    val products: List<ProductDto>
)

fun ProductCategory.toCategory(): Category {
    return Category(
        id = productCategoryId,
        name = productCategoryName,
        productList = products.map {
            it.toProduct()
        },
        isCurrent = false
    )
}
