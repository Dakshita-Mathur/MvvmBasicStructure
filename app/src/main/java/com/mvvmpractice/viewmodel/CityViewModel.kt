package com.mvvmpractice.viewmodel

import android.os.Looper
import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvmpractice.model.City
import com.mvvmpractice.model.CityDataProvider

class CityViewModel : ViewModel() {

    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 2500L

    init {
        citiesLoop()
    }

    fun getCityData() : LiveData<City> = cityData

    private fun citiesLoop() {
        Handler(Looper.getMainLooper()).postDelayed({ updateCity() }, delay)
    }

    private fun updateCity() {
        currentIndex++
        currentIndex %= cities.size

        cityData.value = cities[currentIndex]
        citiesLoop()
    }
}