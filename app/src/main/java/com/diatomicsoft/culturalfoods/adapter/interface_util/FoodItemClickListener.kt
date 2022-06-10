package com.diatomicsoft.culturalfoods.adapter.interface_util
import android.view.View
import com.diatomicsoft.culturalfoods.model.data.Food

interface FoodItemClickListener {
    fun foodItemClickListener(view: View, item: Food)
}
