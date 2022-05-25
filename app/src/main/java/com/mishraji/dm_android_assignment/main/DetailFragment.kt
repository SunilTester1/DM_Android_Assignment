package com.mishraji.dm_android_assignment.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.mishraji.dm_android_assignment.callback.IOnBackPressed
import com.mishraji.dm_android_assignment.data.Cake
import com.mishraji.dm_android_assignment.databinding.FragmentDetailBinding


class DetailFragment : Fragment(), IOnBackPressed {

    private lateinit var viewModel: CakeViewModel
    private lateinit var singleData : Cake
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater , container, false)
        viewModel = ViewModelProvider(requireActivity()).get(CakeViewModel::class.java)
        viewModel.cake.observe(requireActivity()) { result ->
            binding.textViewNo.text = singleData.id
            binding.textViewName.text = singleData.name
            binding.textViewCount.text = "Toppings count: ${singleData.topping.size.toString()}"
        }
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(data : Cake) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    singleData = data
                }
            }
    }
    override fun onBackPressed(): Boolean {
        return false
    }
}