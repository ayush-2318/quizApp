package com.example.quizapp


import android.content.Intent
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_question.*


class QuizQuestionActivity : AppCompatActivity() {
    private var mcurpos:Int=1
    private var mquestionList:ArrayList<QUESTION>?=null
    private var mselectedoptioncurpos:Int=0
    private var mcorrectans:Int=0
    private var musername:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        musername=intent.getStringExtra(Constants.User_Name)
         mquestionList=Constants.getquestions()

        setquestion()
        tvoption1.setOnClickListener{
            selectedOptionview(tvoption1,1)
        }
        tvoption2.setOnClickListener{
            selectedOptionview(tvoption2,2)
        }

        tvoption3.setOnClickListener{
            selectedOptionview(tvoption3,3)
        }

        tvoption4.setOnClickListener{
            selectedOptionview(tvoption4,4)
        }
        btnsumbit.setOnClickListener{
            if(mselectedoptioncurpos==0){
                mcurpos++
                if(mcurpos<=mquestionList!!.size){
                    setquestion()
                } else{
                    //Toast.makeText(this,"you have successfully completed the quiz",Toast.LENGTH_SHORT).show()
                    val intent=Intent(this,ResultActivity::class.java)
                    intent.putExtra(Constants.User_Name,musername)
                    intent.putExtra(Constants.Correct_ans,mcorrectans)
                    intent.putExtra(Constants.Total_Question,mquestionList!!.size)
                    startActivity(intent)
                }
            }
            else{
                val question=mquestionList?.get(mcurpos-1)
                if(question!!.correctanswer!=mselectedoptioncurpos){
                    AnswerView(mselectedoptioncurpos,R.drawable.wrong_option)

                }
                else{
                    mcorrectans++
                }

                AnswerView(question.correctanswer,R.drawable.correctoption)
                if(mcurpos==mquestionList!!.size){
                    btnsumbit.text="FINISH"
                }
                else{
                    btnsumbit.text="GO TO NEXT QUESTION"

                }
                mselectedoptioncurpos=0


            }

        }




    }

    val timer = object: CountDownTimer(30000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            tvtime.setText("seconds remaining: " + millisUntilFinished / 1000)
        }

        override fun onFinish() {
            mcurpos++;
            if(mcurpos<=mquestionList!!.size){

                setquestion()
            }
            else{
                //Toast.makeText(this,"you have successfully completed the quiz",Toast.LENGTH_SHORT).show()
                val intent=Intent(this@QuizQuestionActivity,ResultActivity::class.java)
                intent.putExtra(Constants.User_Name,musername)
                intent.putExtra(Constants.Correct_ans,mcorrectans)
                intent.putExtra(Constants.Total_Question,mquestionList!!.size)
                startActivity(intent)
            }


        }
    }

    private fun setquestion(){
        // mcurpos=1
        timer.start()

        val question=mquestionList!![mcurpos-1]
        defaultOptionview()
        if(mcurpos==mquestionList!!.size){
            btnsumbit.text="FINISH"
        }
        else{
            btnsumbit.text="SUMBIT"

        }
        progressBar.progress=mcurpos
        tvprogresstext.text="$mcurpos"+"/"+progressBar.max
        tvquestion.text=question!!.question
        tvoption1.text=question.optionone
        tvoption2.text=question.optiontwo
        tvoption3.text=question.optionthree
        tvoption4.text=question.optionfour
    }
    private fun defaultOptionview(){
        val options=ArrayList<TextView>()
        options.add(0,tvoption1)
        options.add(1,tvoption2)
        options.add(2,tvoption3)
        options.add(3,tvoption4)
        for(option in options){
           option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.bac)

        }
    }

//    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.tvoption1->{
//                selectedOptionview(tvoption1,1)
//            }
//            R.id.tvoption2->{
//                selectedOptionview(tvoption2,2)
//
//            }
//            R.id.tvoption3->{
//                selectedOptionview(tvoption3,3)
//            }
//            R.id.tvoption4->{
//                selectedOptionview(tvoption4,4)
//            }
//
//        }
//
//    }
    private fun selectedOptionview(tv: TextView,selectedoptionNum:Int){
        defaultOptionview()
        mselectedoptioncurpos=selectedoptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selectedoption)


    }
    private fun AnswerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                tvoption1.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvoption2.background=ContextCompat.getDrawable(this,drawableView)

            }
            3->{
                tvoption3.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                tvoption4.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }


}