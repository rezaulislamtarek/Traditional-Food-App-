package com.diatomicsoft.culturalfoods.ui.intro

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.diatomicsoft.culturalfoods.R
import com.diatomicsoft.culturalfoods.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    private var binding: FragmentIntroBinding? = null
    lateinit var viewModel: IntroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().window.statusBarColor = Color.BLACK
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        activity?.actionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.dark_yellow
                )
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(IntroViewModel::class.java)
        binding = FragmentIntroBinding.inflate(layoutInflater,container,false)
        binding?.vm = viewModel
        binding?.lifecycleOwner = this
        binding?.exploreBtn?.setOnClickListener{navigateToFoodList()}
        return binding?.root;
    }

    private fun navigateToFoodList(){
        val navController = findNavController()
        Log.d("navFun","click")
        navController.navigate(IntroFragmentDirections.actionIntroFragmentToFoodListFragment())
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        requireActivity().window.statusBarColor = Color.BLACK
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        val color = 0xFF000000
        requireActivity().window.statusBarColor = color.toInt()
    }


}