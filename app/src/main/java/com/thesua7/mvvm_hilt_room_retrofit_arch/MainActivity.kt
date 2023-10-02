package com.thesua7.mvvm_hilt_room_retrofit_arch

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.Data
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.OccupationModel
import com.thesua7.mvvm_hilt_room_retrofit_arch.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.tv_tv)
        var temp = ""
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getAllRepositroyList().observe(this, Observer<List<Data>> {

            it.forEach{
                temp = temp+" "+it+"\n"
            }
            textView.text = temp


        })
        viewModel.makeApiCall()

    }



//    private fun initMainViewModel() {
//
//
//
//    }
}