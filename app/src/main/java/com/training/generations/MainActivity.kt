package com.training.generations

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.datepicker.MaterialDatePicker
import com.training.generations.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
   lateinit var  binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root

        setContentView(view)
        val calendar: Calendar = Calendar.getInstance()
        val sharedPreferences = getSharedPreferences("PERSON", MODE_PRIVATE)!!
        val dateLong = sharedPreferences.getLong("PERSON_YEAR", 0L)
        val picker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Input your Birthday")
            .setSelection(dateLong)
            .build()
        calendar.time = Date(dateLong)
        val year = calendar.get(Calendar.YEAR)

        showImage(year)
        binding.tv.text = "Last Result: $year"

        binding.iv.setOnClickListener {
            when (year) {
                in 1946..1960 -> openWebPage("https://en.wikipedia.org/wiki/Baby_boomers")
                in 1961..1980 -> openWebPage("https://en.wikipedia.org/wiki/Generation_X")
                in 1981..1996 -> openWebPage("https://en.wikipedia.org/wiki/Generation_Y")
                in 1997..2012 -> openWebPage("https://en.wikipedia.org/wiki/Generation_Z")
            }
        }

        binding.fabExt.setOnClickListener {
            picker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")
        }


        picker.addOnPositiveButtonClickListener {
            calendar.time = Date(it)
            val year = calendar.get(Calendar.YEAR)
            showImage(year)
            binding.tv.text = "Last Result: $year"
            sharedPreferences.edit().putLong("PERSON_YEAR", it).apply()
        }
    }

    private fun openWebPage(url: String) {
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (webIntent.resolveActivity(packageManager) != null) {
            startActivity(webIntent)
        }
    }

    private fun showImage(year:Int){
        when (year){
            in 1946..2012 ->  binding.iv.isVisible = true
            else -> binding.iv.isVisible = false
        }

        when (year) {
            in 0..1945 -> Toast.makeText(this, "You status unknown!", Toast.LENGTH_LONG).show()
            in 1946..1960 -> binding.iv.setImageResource(R.drawable.zx)
            in 1961..1980 -> binding.iv.setImageResource(R.drawable.a6)
            in 1981..1996 ->  binding.iv.setImageResource(R.drawable.go)
            in 1997..2012 -> binding.iv.setImageResource(R.drawable.ml)
            else -> Toast.makeText(this, "You are very young!", Toast.LENGTH_LONG).show()
        }
    }

//    override fun onResume() {
//        super.onResume()
//
//        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        val view: View = binding.root
//
//        setContentView(view)
//        binding.tv.text = "Last Result: $year"
//        when (year) {
//            in 0..1945 -> {
//                Toast.makeText(this, "You status unknown!", Toast.LENGTH_LONG).show()
//                binding.iv.isVisible = false
//            }
//            in 1946..1960 -> {
//                binding.iv.setImageResource(R.drawable.zx)
//                binding.iv.isVisible = true
//            }
//            in 1961..1980 -> {
//                binding.iv.setImageResource(R.drawable.a6)
//                binding.iv.isVisible = true
//            }
//            in 1981..1996 -> {
//                binding.iv.setImageResource(R.drawable.go)
//                binding.iv.isVisible = true
//            }
//            in 1997..2012 -> {
//                binding.iv.setImageResource(R.drawable.ml)
//                binding.iv.isVisible = true
//            }
//            else -> {
//                Toast.makeText(this, "You are very young!", Toast.LENGTH_LONG).show()
//                binding.iv.isVisible = false
//            }
//        }
//
//
//    }
}