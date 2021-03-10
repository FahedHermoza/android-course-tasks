package com.emedinaa.kotlinapp.data.storage.local

import android.content.Context
import android.content.SharedPreferences

/**
 * @author Eduardo Medina
 */
class PreferencesHelper(private val context: Context) {

    private val MY_NOTES_PREFERENCES = "com.emedinaa.kotlinapp"
    private val PREFERENCES_USERNAME = "$MY_NOTES_PREFERENCES.username"
    private val PREFERENCES_TOKEN = "$MY_NOTES_PREFERENCES.token"


    fun saveSession(username: String,token:String) {
        val editor = getEditor()
        editor.putString(PREFERENCES_USERNAME, username)
        editor.putString(PREFERENCES_TOKEN, token)
        editor.apply()
    }

    fun session(): String? {
        val sharedPreferences = getSharedPreferences()
        return sharedPreferences.getString(PREFERENCES_TOKEN, null)
    }

    fun isSignedIn(): Boolean {
        val preferences = getSharedPreferences()
        return preferences.contains(PREFERENCES_USERNAME) && preferences.contains(PREFERENCES_TOKEN)
    }

    fun clearSession(){
        val editor = getEditor()
        editor.remove(PREFERENCES_USERNAME)
        editor.remove(PREFERENCES_TOKEN)
        editor.apply()
    }

    fun clear(){
        val editor = getEditor()
        editor.clear()
        editor.apply()
    }

    private fun getEditor(): SharedPreferences.Editor {
        val preferences = getSharedPreferences()
        return preferences.edit()
    }

    private fun getSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences(MY_NOTES_PREFERENCES, Context.MODE_PRIVATE)
    }

}