package com.farhanryanda.designpattern.network

import com.farhanryanda.designpattern.model.ResponseCar
import com.farhanryanda.designpattern.model.ResponseCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("admin/car")
    fun getAllCar(): Call<List<ResponseCarItem>>
}