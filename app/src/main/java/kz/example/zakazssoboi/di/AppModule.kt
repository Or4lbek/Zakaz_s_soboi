package kz.example.zakazssoboi.di

import dagger.Module
import dagger.Provides
import kz.example.zakazssoboi.common.Constants
import kz.example.zakazssoboi.data.network.NetworkManager
import kz.example.zakazssoboi.data.network.interceptor.AuthorizationInterceptor
import kz.example.zakazssoboi.data.network.provider.UserProvider
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder().apply {
            addInterceptor(AuthorizationInterceptor(UserProvider.instance!!))
            connectTimeout(5, TimeUnit.MINUTES)
            readTimeout(5, TimeUnit.MINUTES)
            writeTimeout(5, TimeUnit.MINUTES)
        }.build()
        return builder
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(NetworkManager.gson!!))
            .client(NetworkManager.client!!)
            .build()
    }
}