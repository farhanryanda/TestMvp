package com.farhanryanda.designpattern.presenter

import com.farhanryanda.designpattern.model.ResponseCarItem
import com.farhanryanda.designpattern.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarPresenter(val viewcar: CarView) {

    fun getAllCar() {
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<ResponseCarItem>> {
                override fun onResponse(
                    call: Call<List<ResponseCarItem>>,
                    response: Response<List<ResponseCarItem>>
                ) {
                    if (response.isSuccessful) {
                        viewcar.onSuccess(response.message(),response.body()!!)
                    } else {
                        viewcar.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<ResponseCarItem>>, t: Throwable) {
                    viewcar.onError(t.message!!)
                }

            })
    }
}