package com.diatomicsoft.culturalfoods.ui.foodlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diatomicsoft.culturalfoods.model.data.Food
import com.diatomicsoft.culturalfoods.model.repository.FoodRepo
import kotlinx.coroutines.launch

class FoodListViewModel: ViewModel() {
    var foodList = MutableLiveData<ArrayList<Food>>()
    init {
        var repo = FoodRepo()
        viewModelScope.launch {
            foodList.value = repo.getFoodList()
        }
    }
}