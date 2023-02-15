package com.mvvmpractice.model

import com.mvvmpractice.R

class CityDataProvider {

    private val cities = arrayListOf<City>()

    init {
        cities.add(City("Bangkok", R.drawable.city1, 100_000_000))
        cities.add(City("Beijing", R.drawable.city2, 21_500_000))
        cities.add(City("London", R.drawable.city3, 8_400_000))
        cities.add(City("Paris", R.drawable.city4, 9_500_000))
        cities.add(City("Rio", R.drawable.city5, 2_100_000))
        cities.add(City("Rome", R.drawable.city6, 46_000_000))
        cities.add(City("Singapore", R.drawable.city7, 580_000_000))
        cities.add(City("Sydney", R.drawable.city8, 28_000_000))
        cities.add(City("Tokyo", R.drawable.city9, 57_000_000))
    }

    fun getCities() = cities
}