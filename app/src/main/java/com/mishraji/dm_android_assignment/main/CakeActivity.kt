package com.mishraji.dm_android_assignment.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mishraji.dm_android_assignment.R
import com.mishraji.dm_android_assignment.callback.IOnBackPressed
import com.mishraji.dm_android_assignment.databinding.ActivityCakeBinding
import com.mishraji.dm_android_assignment.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CakeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCakeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(MainFragment.newInstance(), "Main")


    }
    fun setFragment(fragment : Fragment , tag : String)
    {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fc, fragment, tag).addToBackStack( "tag" )
        ft.commit()
    }
    override fun onBackPressed() {
        val fragment =
            this.supportFragmentManager.findFragmentById(R.id.fc)
        (fragment as? IOnBackPressed)?.onBackPressed()?.not()?.let {
            super.onBackPressed()
        }
    }
}