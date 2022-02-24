package kz.example.zakazssoboi.data.network.provider

interface IUserProvider {

    fun getAuthToken(): String?

    fun saveAuthToken(authToken: String?)

}
