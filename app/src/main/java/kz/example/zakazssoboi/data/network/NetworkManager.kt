package kz.example.zakazssoboi.data.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kz.example.zakazssoboi.common.Constants
import kz.example.zakazssoboi.data.network.interceptor.AuthorizationInterceptor
import kz.example.zakazssoboi.data.network.provider.UserProvider
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkManager {

    private var gson: Gson? = null
        get() {
            if (field == null) {
                val gsonBuilder = GsonBuilder()
                gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                gsonBuilder.serializeNulls()
                gson = gsonBuilder.create()
            }
            return field
        }

    private var client: OkHttpClient? = null
        get() {
            if (field == null) {
                val builder = OkHttpClient.Builder()
                builder.addInterceptor(AuthorizationInterceptor(UserProvider.instance!!))
                builder.connectTimeout(5, TimeUnit.MINUTES)
                builder.readTimeout(5, TimeUnit.MINUTES)
                builder.writeTimeout(5, TimeUnit.MINUTES)
                client = builder.build()
            }
            return field
        }


    var retrofit: Retrofit? = null
        get() {
            if (field == null) {
                field = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson!!))
                    .client(client!!)
                    .build()
            }
            return field
        }

}