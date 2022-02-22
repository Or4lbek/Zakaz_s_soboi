package kz.example.zakazssoboi.domain.repository

interface AuthorizationRepository {
    fun login(email: String, password: String)
}