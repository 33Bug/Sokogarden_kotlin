package com.bug.sokogardenapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        sign up intent
        val signup = findViewById<Button>(R.id.signup)
        signup.setOnClickListener {
            val intent = Intent(applicationContext, Signup::class.java)
            startActivity(intent)
        }
        val about = findViewById<Button>(R.id.about)
        about.setOnClickListener {
            val intent = Intent(applicationContext, About::class.java)
            startActivity(intent)
        }

//        sign in intent
        val signin = findViewById<Button>(R.id.signin)
        signin.setOnClickListener {
            val intent = Intent(applicationContext, Signin::class.java)
            startActivity(intent)
        }
        // Fetch recylerview and progressbar
        val progressBar = findViewById<ProgressBar>(R.id.progressbar)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        //  Define your url
        val url = "https://bug.alwaysdata.net/api/get_product_details"

        //  Get the object of class APiHelper
        val helper = ApiHelper(applicationContext)

        //  We have a function called loadProducts, its inside ApiHelper
        //  Pass the 3 arguments which are url(api endpoint), recyclerview and progressbar
        helper.loadProducts(url, recyclerView, progressBar )




    }
}