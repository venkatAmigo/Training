package com.example.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CursorAdapter
import android.widget.Toast
import com.example.firstapplication.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity() {
    lateinit var binding:ActivityDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val countries = arrayOf("India","China","India","China")
        val images = arrayOf(R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,)

        binding.imageView.setImageResource(R.drawable.download)

        binding.imageButton.setOnClickListener {

            //Intent
            /*
            Implicit intent
            Explicit intent
            * */
            startActivity(Intent(this, MainActivity::class.java))
        }


       // val adapter = ArrayAdapter(this,R.layout.my_layout_item,R.id.textView, countries)

        val listAdapter = ListAdapter(this, countries, images)
        binding.listView.adapter = listAdapter

        // binding.gridView.adapter = listAdapter

    }
}