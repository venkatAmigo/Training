package com.example.firstapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() , OnClickListener {


   lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.interested.setOnClickListener(this)
        binding.notInterested.setOnClickListener(this)

        binding.button.setOnClickListener {
            binding.timePicker.setIs24HourView(true)

        }

        binding.buttonTest.setOnClickListener {
            val selectedGender = binding.radioGroup.checkedRadioButtonId
        }

        binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            if(i == R.id.radioButton2)
            Toast.makeText(this, "Male Selected", Toast.LENGTH_SHORT).show()
        }

        binding.toggleButton.setOnClickListener {
            Toast.makeText(this, binding.toggleButton.text.toString(), Toast.LENGTH_SHORT).show()
        }

        binding.switch1.setOnClickListener {
            Toast.makeText(this, ""+binding.switch1.isChecked, Toast.LENGTH_SHORT).show()
        }


        val myInterests = resources.getStringArray(R.array.my_interests)
        val myNewInterstes = arrayOf("One","Two","Three")

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,myNewInterstes)

        binding.spinner.adapter = arrayAdapter

        binding.spinner.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity,myNewInterstes[position],
                    Toast
                    .LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.timePicker.setOnTimeChangedListener { _, hour, minute ->
            Toast.makeText(this, "$hour : $minute", Toast.LENGTH_SHORT).show()
        }

        binding.datePicker.setOnDateChangedListener { datePicker, i, i2, i3 ->
            Toast.makeText(this, "$i/${i2+1}/$i3", Toast.LENGTH_SHORT).show()
        }

        //TimePicker Dialog
        binding.editText.setOnClickListener {
            val timePickerDialog = TimePickerDialog(this,
                { _, hours, min ->
                    binding.editText.setText("$hours :$min")
                }, 3,30,false )
            timePickerDialog.show()
        }

        //DatePickerDialog

        binding.buttonTest.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                binding.textView.text = "$i ${i2+1} $i3"
            },2023,4,30)
            datePickerDialog.show()
        }

    }

    override fun onClick(p0: View?) {

        when(p0?.id){
            R.id.interested ->  Toast.makeText(this, "Iam Interested", Toast.LENGTH_SHORT).show()
            R.id.not_interested ->  Toast.makeText(this, "Iam not interested", Toast.LENGTH_SHORT)
                .show()
            R.id.button -> {
                if(binding.interested.isChecked){
                    Toast.makeText(this, "first is clicked", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}