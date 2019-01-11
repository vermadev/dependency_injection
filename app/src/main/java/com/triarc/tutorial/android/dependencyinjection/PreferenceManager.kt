package com.triarc.tutorial.android.dependencyinjection

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 11/1/19
 */
class PreferenceManager @Inject constructor(context: Context) {

    private val sharedPreferences: SharedPreferences
    private val preferenceEditor:  SharedPreferences.Editor

    companion object {
        const val Name = "shared_prefs"
    }

    init {
        sharedPreferences = context.getSharedPreferences(Name, Context.MODE_PRIVATE)
        preferenceEditor  = sharedPreferences.edit()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    @Synchronized
    fun setString(key: String, value: String) {
        preferenceEditor.putString(key, value)
        preferenceEditor.apply()
    }
}
