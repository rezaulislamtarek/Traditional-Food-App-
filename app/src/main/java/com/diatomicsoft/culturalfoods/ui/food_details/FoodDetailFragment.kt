package com.diatomicsoft.culturalfoods.ui.food_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.diatomicsoft.culturalfoods.databinding.FragmentFoodDetailBinding
import com.diatomicsoft.culturalfoods.model.db.Prefs
import com.diatomicsoft.culturalfoods.model.repository.FoodRepo

class FoodDetailFragment : Fragment() {
    private val args: FoodDetailFragmentArgs by navArgs()
    var binding: FragmentFoodDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodDetailBinding.inflate(layoutInflater,container,false)
        binding?.food = args.food
        var sp = Prefs(requireContext())
        binding?.ratingBar!!.rating = sp.getRating(args.food.id)
        binding?.lifecycleOwner = this
        return binding?.root
    }

    fun setRating(){
        var rb = binding?.ratingBar
        //rb?.rating
        rb?.setOnClickListener {
            rb.rating = 4.0F
        }
    }

    override fun onDetach() {
        super.onDetach()
        var sp = Prefs(requireContext())
        sp.saveRating(args.food.id, binding!!.ratingBar.rating)
        //repo.setFoodRating(, args.food.id)
    }

}