package kz.example.zakazssoboi.domain.use_case

import kz.example.zakazssoboi.domain.repository.AuthorizationRepository

class LoginUseCase(private val repository: AuthorizationRepository) {
    operator fun invoke(email: String, password: String) {
        repository.login(email, password)
    }
}