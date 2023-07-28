package com.example.quizapp

object Constants {
    const val User_Name:String="user_name"
    const val Total_Question:String="total_question"
    const val Correct_ans:String="correct_ans"
    fun getquestions():ArrayList<QUESTION>{
        val questionList=ArrayList<QUESTION>()
        val question1=QUESTION(
            1,
            " If the sizes of charged bodies are very small compared to the distances between them, we treat them as",
            "Zero charges",
            "Point charges" ,
            "Single charge" ,
            "No charges",
            2)
        questionList.add(question1)
        val question2=QUESTION(
            2,
            " The force per unit charge is known as",
            "Electric current",
            "Electric potential",
            "Electric field",
            "Electric space",
            3)
        questionList.add(question2)

        val question3=QUESTION(
            3,
            "What is the dielectric constant of a metal?",
            "-1",
            "0" ,
            "1" ,
            "Infinite",
            4)
        questionList.add(question3)

        val question4=QUESTION(
            4,
            "gives the information on field strength, direction, and nature of the charge. ","Electric current",
            "Electric flux" ,
            "Electric field" ,
            "Electric potential",
            3)
        questionList.add(question4)

        val question5=QUESTION(
            5,
            " What happens when a glass rod is rubbed with silk",
            "gains protons from silk" ,
            "gains electrons from silk" ,
            "gives electrons to silk" ,
            "gives protons to silk",
            1)
        questionList.add(question5)

        return questionList

    }
}