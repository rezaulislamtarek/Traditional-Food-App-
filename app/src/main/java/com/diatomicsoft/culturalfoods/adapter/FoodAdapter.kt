package com.diatomicsoft.culturalfoods.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.diatomicsoft.culturalfoods.R
import com.diatomicsoft.culturalfoods.adapter.interface_util.FoodItemClickListener
import com.diatomicsoft.culturalfoods.databinding.RvFoodBinding
import com.diatomicsoft.culturalfoods.model.data.Food

class FoodAdapter(private val data: List<Food>, val listener: FoodItemClickListener) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    inner class FoodViewHolder(val binding: RvFoodBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = DataBindingUtil.inflate<RvFoodBinding>(
            LayoutInflater.from(parent.context),
            R.layout.rv_food,
            parent, false
        )
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.binding.food = data[position]
        holder.binding.root.setOnClickListener {
            listener.foodItemClickListener(it,data[position])  }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


/*
class CarAdapter(val data: List<Car>, val listener: CarItemClickListener) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    inner class CarViewHolder(val binding: RvCarBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = DataBindingUtil.inflate<RvCarBinding>(
            LayoutInflater.from(parent.context),
            R.layout.rv_car,
            parent, false
        )
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.binding.car = data[position]
        holder.binding.root.setOnClickListener {
            listener.itemClickListener(it,data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
 */