package kz.example.zakazssoboi.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val price: Int,
    var counter: Int = 0
) : Parcelable {
    fun getPriceAsString(): String {
        return "$price тг"
    }
}

