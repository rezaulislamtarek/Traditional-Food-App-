package com.diatomicsoft.culturalfoods.ui.foodlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.diatomicsoft.culturalfoods.adapter.FoodAdapter
import com.diatomicsoft.culturalfoods.adapter.interface_util.FoodItemClickListener
import com.diatomicsoft.culturalfoods.databinding.FragmentFoodListBinding
import com.diatomicsoft.culturalfoods.model.data.Food

class FoodListFragment : Fragment(), FoodItemClickListener {
    private var binding: FragmentFoodListBinding? = null
    lateinit var model: FoodListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        model = ViewModelProvider(this).get(FoodListViewModel::class.java)
        binding = FragmentFoodListBinding.inflate(layoutInflater,container,false)
        binding?.vm = model
        binding?.lifecycleOwner = this
        model.foodList.observe(viewLifecycleOwner, Observer {
            initRecyclerView(it)
        })
        return binding?.root
    }

    private fun initRecyclerView(data: List<Food>){
        val listener = this
        binding?.apply {
            rvFoodList.layoutManager = LinearLayoutManager(requireContext())
            rvFoodList.adapter = FoodAdapter(data, listener )
        }
    }

    override fun foodItemClickListener(view: View, item: Food) {
        findNavController().navigate(FoodListFragmentDirections.actionFoodListFragmentToFoodDetailFragment(item))
    }


}