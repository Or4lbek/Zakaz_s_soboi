package kz.example.zakazssoboi.domain.use_case

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kz.example.zakazssoboi.domain.entity.Restaurant
import kz.example.zakazssoboi.domain.repository.RestaurantRepository
import javax.inject.Inject

class GetRestaurantListUseCase @Inject constructor(
    private val repository: RestaurantRepository,
    private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<List<Restaurant>> = repository.getRestaurantList()
}