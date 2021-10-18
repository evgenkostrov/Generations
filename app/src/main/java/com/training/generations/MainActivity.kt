package com.training.generations

import android.app.DatePickerDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.datepicker.MaterialDatePicker
import com.training.generations.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
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

        binding.tv.text = "Last Result: $year"
        when (year) {
            in 0..1945 -> {
                Toast.makeText(this, "You status unknown!", Toast.LENGTH_LONG).show()
                binding.iv.isVisible = false
            }
            in 1946..1960 -> {
                binding.iv.setImageResource(R.drawable.zx)
                binding.iv.isVisible = true
            }
            in 1961..1980 -> {
                binding.iv.setImageResource(R.drawable.a6)
                binding.iv.isVisible = true
            }
            in 1981..1996 -> {
                binding.iv.setImageResource(R.drawable.go)
                binding.iv.isVisible = true
            }
            in 1997..2012 -> {
                binding.iv.setImageResource(R.drawable.ml)
                binding.iv.isVisible = true
            }
            else -> {
                Toast.makeText(this, "You are very young!", Toast.LENGTH_LONG).show()
                binding.iv.isVisible = false
            }
        }


        binding.fabExt.setOnClickListener {

            picker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")

        }

        picker.addOnPositiveButtonClickListener {

            calendar.time = Date(it)
            val year = calendar.get(Calendar.YEAR)

            binding.tv.text = "Last Result: $year"
            when (year) {
                in 0..1945 -> {
                    Toast.makeText(this, "You status unknown!", Toast.LENGTH_LONG).show()
                    binding.iv.isVisible = false
                }
                in 1946..1960 -> {
                    binding.iv.setImageResource(R.drawable.zx)
                    binding.iv.isVisible = true
                }
                in 1961..1980 -> {
                    binding.iv.setImageResource(R.drawable.a6)
                    binding.iv.isVisible = true
                }
                in 1981..1996 -> {
                    binding.iv.setImageResource(R.drawable.go)
                    binding.iv.isVisible = true
                }
                in 1997..2012 -> {
                    binding.iv.setImageResource(R.drawable.ml)
                    binding.iv.isVisible = true
                }
                else -> {
                    Toast.makeText(this, "You are very young!", Toast.LENGTH_LONG).show()
                    binding.iv.isVisible = false
                }
            }

            sharedPreferences.edit().putLong("PERSON_YEAR", it).apply()


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