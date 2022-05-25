package com.mishraji.dm_android_assignment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mishraji.dm_android_assignment.callback.IOnRecyclerItemClickListener
import com.mishraji.dm_android_assignment.data.Cake
import com.mishraji.dm_android_assignment.databinding.FragmentMainBinding

class MainFragment : Fragment(), IOnRecyclerItemClickListener {

    private lateinit var viewModel: CakeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(CakeViewModel::class.java)
        val cakeAdapter = CakeAdapter(this)

        binding.apply {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = cakeAdapter
            }
            viewModel.cake.observe(requireActivity()) { result ->
                cakeAdapter.setData(result.data as ArrayList<Cake>)
            }
        }
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment()
    }

    override fun onItemClick(data: Any) {
        if (data is Cake) {
            val mActivity = requireActivity() as CakeActivity
            mActivity.setFragment(DetailFragment.newInstance(data), "Detail")
        }
    }
}