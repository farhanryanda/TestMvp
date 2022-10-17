package com.farhanryanda.designpattern.presenter

import com.farhanryanda.designpattern.model.ResponseCarItem

interface CarView {

    fun onSuccess(pesan: String, car: List<ResponseCarItem>)
    fun onError(pesan: String)
}