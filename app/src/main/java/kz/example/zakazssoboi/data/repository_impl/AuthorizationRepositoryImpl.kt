package kz.example.zakazssoboi.data.repository_impl

import kz.example.zakazssoboi.domain.repository.AuthorizationRepository

class AuthorizationRepositoryImpl: AuthorizationRepository {
    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(email: String, password: String) {
        TODO("Not yet implemented")
    }
}