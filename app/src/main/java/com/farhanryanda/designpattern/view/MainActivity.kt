package com.farhanryanda.designpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.farhanryanda.designpattern.R
import com.farhanryanda.designpattern.databinding.ActivityMainBinding
import com.farhanryanda.designpattern.model.ResponseCarItem
import com.farhanryanda.designpattern.presenter.CarPresenter
import com.farhanryanda.designpattern.presenter.CarView

class MainActivity : AppCompatActivity(),CarView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presentercar : CarPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presentercar = CarPresenter(this)
        presentercar.getAllCar()
    }

    override fun onSuccess(pesan: String, car: List<ResponseCarItem>) {
        CarAdapter(car).submitData(car)
        binding.rvCar.adapter = CarAdapter(car)
        binding.rvCar.layoutManager = LinearLayoutManager(this)
    }

    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
    }

}