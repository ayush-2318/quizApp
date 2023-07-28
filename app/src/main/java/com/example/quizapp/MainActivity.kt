package com.example.quizapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //app take full screen
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN

        btnstart.setOnClickListener{
            //check if editText is empty or not
            if(etname.text.toString().isEmpty()){
                Toast.makeText(this,"please enter your name",Toast.LENGTH_SHORT).show()
            }
            //intent to go to QuizQuestionActivity
            else{
                val intent=Intent(this,QuizQuestionActivity::class.java)
                intent.putExtra(Constants.User_Name,etname.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}