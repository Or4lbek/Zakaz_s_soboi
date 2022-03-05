package kz.example.zakazssoboi.domain.repository

interface AuthorizationRepository {
    suspend fun login(email: String, password: String)

    suspend fun signUp(email: String, password: String)
}