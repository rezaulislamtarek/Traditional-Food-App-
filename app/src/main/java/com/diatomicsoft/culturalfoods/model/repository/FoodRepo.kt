package com.diatomicsoft.culturalfoods.model.repository

import com.diatomicsoft.culturalfoods.model.data.Food
import com.diatomicsoft.culturalfoods.model.db.DB

class FoodRepo {
    private var db = DB()
    fun getFoodList(): ArrayList<Food> {
        return db.dataLis
    }
    fun setFoodRating(value: Float?, id: Int){
        if (value != null) {
            db.dataLis[id].rating = value
        }
    }
}