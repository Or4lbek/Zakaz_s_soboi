package kz.example.zakazssoboi.di

import dagger.Module

@Module
class AppModule {

//    @Provides
//    fun provideOkHttpClient(): OkHttpClient {
//        val builder = OkHttpClient.Builder().apply {
//            addInterceptor(AuthorizationInterceptor(UserProvider.instance!!))
//            connectTimeout(5, TimeUnit.MINUTES)
//            readTimeout(5, TimeUnit.MINUTES)
//            writeTimeout(5, TimeUnit.MINUTES)
//        }.build()
//        return builder
//    }
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(): Retrofit {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(NetworkManager.gson!!))
//            .client(NetworkManager.client!!)
//            .build()
//    }
}