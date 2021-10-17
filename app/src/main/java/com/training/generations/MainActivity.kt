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
        var year = 0
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        val sharedPreferences= this.getSharedPreferences("answer", MODE_PRIVATE)?:return

        val picker=MaterialDatePicker.Builder.datePicker()
            .setTitleText("Input your Birthday")
            .setSelection(sharedPreferences.getLong("Calendar",calendar.timeInMillis))
            .build()


        binding.fabExt.shrink()
        binding.fabExt.setAnimateShowBeforeLayout(true)
        binding.fabExt.setOnClickListener {
picker.show(supportFragmentManager,"MATERIAL")

        }

        picker.addOnPositiveButtonClickListener {

            calendar.time= Date(it)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            binding.tv.text="Last Result: $year"
            sharedPreferences.edit().putLong("Calendar",it).apply()

            when (year){
                in 0..1946 -> {
                    Toast.makeText(this, "Your status unknown",Toast.LENGTH_LONG).show()
                    binding.iv.isVisible=false
                }
                in 1946..1960 -> {binding.iv.setImageResource(R.drawable.zx)
                    binding.iv.isVisible=true}
                in 1961..1980 ->  {binding.iv.setImageResource(R.drawable.a6)
                binding.iv.isVisible=true}
                in 1981..1996 ->  {binding.iv.setImageResource(R.drawable.go)
            binding.iv.isVisible=true}
                in 1997..2012 ->  {binding.iv.setImageResource(R.drawable.ml)
        binding.iv.isVisible=true}
                else -> {
                    Toast.makeText(this, "Your every young",Toast.LENGTH_LONG).show()
                    binding.iv.isVisible=false
                }




            }


        }



    }




}