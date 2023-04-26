package com.example.firstapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter(private val context: Activity, private val values: Array<String>, private val
images: Array<Int>) :
    ArrayAdapter<String>(context,R.layout.my_layout_item, values) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val view = inflater.inflate(R.layout.my_layout_item,null,true)
        val imageView = view.findViewById<ImageView>(R.id.left_image)
        val textView = view.findViewById(R.id.textView) as TextView
        textView.text = values[position]
        imageView.setImageResource(images[position])
        return view
    }
}
