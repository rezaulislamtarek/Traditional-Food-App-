package com.diatomicsoft.culturalfoods.model.db

import android.content.Context
import android.content.SharedPreferences

open class Prefs(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("rat",Context.MODE_PRIVATE)
    fun saveRating(id: Int, rating: Float){
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putFloat(id.toString(), rating)
        editor.apply()
        editor.commit()
    }

    fun getRating(id: Int): Float {
        return sharedPreferences.getFloat(id.toString(), 0.0F)
    }
}