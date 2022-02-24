package kz.example.zakazssoboi.data.network.provider

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences


class UserProvider(private val context: Context) : IUserProvider {

    companion object {
        private const val PREF_NAME = "GADGETJET"
        private const val KEY_AUTH_TOKEN = "KEY_AUTH_TOKEN"

        @SuppressLint("StaticFieldLeak")
        var instance: UserProvider? = null
    }

    init {
        instance = this
    }

    private var sharedPreferences: SharedPreferences? = null
        get() {
            if (field == null)
                field = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            return field
        }

    override fun getAuthToken(): String? = sharedPreferences?.getString(
        KEY_AUTH_TOKEN, null
    )

    override fun saveAuthToken(authToken: String?) {
        val preferences = sharedPreferences
        val editor = preferences?.edit()
        editor?.putString(KEY_AUTH_TOKEN, authToken)
        editor?.apply()
    }

}
