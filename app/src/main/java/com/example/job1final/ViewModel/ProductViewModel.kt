package com.example.job1final.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.job1final.ApiInstance.apiService
import com.example.job1final.Product
import kotlinx.coroutines.launch

class ProductViewModel:ViewModel() {
    private val _product = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _product


    init {
        viewModelScope.launch{
            fetchproducts()
        }
    }

    private suspend fun fetchproducts() {
        try {
            val response =  apiService.getProducts()
            _product.postValue(response)
        }catch (e:Exception){

        }
    }



}