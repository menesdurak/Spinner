package com.menesdurak.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var listOfItems = arrayOf("Item1", "Item2", "Item3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerId = findViewById<Spinner>(R.id.spinner)
        //Get From Resources
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.planets_array,
//            android.R.layout.simple_spinner_item
//        ).also {
//            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinnerId.adapter = it
//        }

        //Get From String Array
        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listOfItems
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerId.adapter = it
        }
        spinnerId.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity, "Selected item is: " + listOfItems[p2], Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }
}