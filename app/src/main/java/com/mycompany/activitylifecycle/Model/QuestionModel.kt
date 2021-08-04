package com.mycompany.activitylifecycle.Model

import androidx.lifecycle.ViewModel

class QuestionModel : ViewModel() {
    var no1: Int = 0
    var no2: Int = 0
    var name: String = ""
//    var answer : Int = 0 , answer can get form variable so no need create to reduce dependency

    //When Model is created I want to generateQuestion
    init{
        generateQuestion()
    }

    fun getAnswer(): Int{
        return no1 + no2
    }

    fun generateQuestion() : String{
        no1 = (Math.random()*100).toInt()
        no2 = (Math.random()*100).toInt()

        //Other write format is ${no1}
        return "$no1 + $no2 = ?"
    }

    //: means return data type
    fun getQuestion(): String{
        return "$no1 + $no2 = ?"
    }

    //Static means one copy
    // ? means allow to have null datatype, if object no created then it become null
    // This is Static and Share the model
    companion object{
        private var instant : QuestionModel? = null

        fun getInstant() =
            instant ?: synchronized(QuestionModel::class.java){
                instant ?: QuestionModel().also { instant = it }
            }
    }
}