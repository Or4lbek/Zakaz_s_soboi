package kz.example.zakazssoboi.presentation.view_model

import androidx.lifecycle.ViewModel
import kz.example.zakazssoboi.domain.entity.Restaurant

class RestaurantListViewModel : ViewModel() {

    var restaurantList: ArrayList<Restaurant> = ArrayList()

    init {
        restaurantList.add(
            Restaurant(
                1,
                "Del Papa",
                "ул. Бухар жырау, 66, уг. ул. Ауэзова",
                "https://media-cdn.tripadvisor.com/media/photo-s/13/c5/15/2f/interiors.jpg"
            )
        )
        restaurantList.add(
            Restaurant(
                2,
                "ул. Кабанбай батыра 83",
                "ул. Бухар жырау, 66, уг. ул. Ауэзова",
                "https://restolife.kz/upload/information_system_6/2/1/4/item_21447/information_items_property_24075.jpg"
            )
        )
        restaurantList.add(
            Restaurant(
                3,
                "Mamma mia",
                "ул. Панфилова 109",
                "https://media-cdn.tripadvisor.com/media/photo-s/0a/58/db/09/mamma-mia.jpg"
            )
        )
        restaurantList.add(
            Restaurant(
                4,
                "Bahandi Burger",
                "ул. Байтурсынова 61",
                "https://www.localguidesconnect.com/t5/image/serverpage/image-id/609103i935F61DE5BBBEA81?v=v2"
            )
        )
        restaurantList.add(
            Restaurant(
                5,
                "KFC",
                "ул. Аксай 4, 4a",
                "https://media-cdn.tripadvisor.com/media/photo-s/1a/d2/f1/bd/kfc.jpg"
            )
        )
        restaurantList.add(
            Restaurant(
                6,
                "Del Papa",
                "ул. Бухар жырау, 66, уг. ул. Ауэзова",
                "https://media-cdn.tripadvisor.com/media/photo-s/13/c5/15/2f/interiors.jpg"
            )
        )
        restaurantList.add(
            Restaurant(
                7,
                "ул. Кабанбай батыра 83",
                "ул. Бухар жырау, 66, уг. ул. Ауэзова",
                "https://restolife.kz/upload/information_system_6/2/1/4/item_21447/information_items_property_24075.jpg"
            )
        )
        restaurantList.add(
            Restaurant(
                8,
                "Mamma mia",
                "ул. Панфилова 109",
                "https://media-cdn.tripadvisor.com/media/photo-s/0a/58/db/09/mamma-mia.jpg"
            )
        )
    }
}