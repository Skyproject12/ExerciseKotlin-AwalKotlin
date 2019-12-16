package com.example.awalkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textHello= findViewById<TextView>(R.id.text_kotlin);
        // settext in kotlin
        textHello.text= "Hello Kotlin";
    }
}
