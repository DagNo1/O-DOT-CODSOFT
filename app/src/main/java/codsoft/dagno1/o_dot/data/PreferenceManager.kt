package codsoft.dagno1.o_dot.data

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val sharedPreferences : SharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    fun getUsername(): String?{
        return sharedPreferences.getString("username", null)
    }
    fun createUser(userName: String) {
        sharedPreferences.edit().putString("username", userName).apply()
    }
    //    name(key: String, defaultValue: String): String{
//        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
//    }
}