package com.vishtech.demomvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vishtech.demomvvm.model.Repository
import com.vishtech.demomvvm.model.data.Airline
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    init {
        viewModelScope.launch {
           val response = repository.getAirlineData()
            if(response.isSuccessful) {
                response.body()?.let { airlineList ->
                    insertAll(*airlineList.toTypedArray())
                }
            }
        }
    }
    val airlineList = repository.airlineList

    fun insert(airline: Airline) = viewModelScope.launch {
        repository.insert(airline)
    }

    fun insertAll(vararg airline: Airline) = viewModelScope.launch {
        repository.insertAll(airline)
    }

}

class MainViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown view model")
    }
}