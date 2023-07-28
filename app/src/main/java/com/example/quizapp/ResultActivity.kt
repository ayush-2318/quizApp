package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username=intent.getStringExtra(Constants.User_Name)
        val correctans=intent.getIntExtra(Constants.Correct_ans,0)
        val totalques=intent.getIntExtra(Constants.Total_Question,0)
        tvname.text=username
        tvscore.text="your Score is $correctans out of $totalques"
        btnfinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}