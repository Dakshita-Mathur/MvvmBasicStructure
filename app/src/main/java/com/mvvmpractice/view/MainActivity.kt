package com.mvvmpractice.view

import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mvvmpractice.R
import com.mvvmpractice.databinding.ActivityMainBinding
import com.mvvmpractice.viewmodel.CityViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var notifyManager: NotificationManager? = null

    /**
     * First way of init viewModel in view
     * but we have some more options to init viewModel in class*/
    private val viewModel: CityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.handler=this

        /**
         * Second way of init viewModel in view
         * viewModel = ViewModelProvider(this).get(CityViewModel::class.java)*/
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onClick(view: View){
        when(view.id){

        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getCityData().observe(this, Observer { city ->
            binding.imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, city.image, applicationContext.theme))
            binding.cityNameTV.text = city.name
            binding.cityPolulationTV.text = city.populations.toString()
        })
    }
}