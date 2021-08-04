package com.mycompany.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mycompany.activitylifecycle.Model.QuestionModel

//A extends B SecondActivity extends AppCompatActivity
class SecondActivity : AppCompatActivity() {

    private lateinit var myModel : QuestionModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Log //It is the log information for message like error message
        Log.i("LifeCycle", "onCreate")

        //variable
        val btn : Button = findViewById(R.id.btnAdd)
        val tv : TextView = findViewById(R.id.tvQuestion)
        val tvName : TextView = findViewById(R.id.tvName)

//        myModel = QuestionModel() this will create new Model

        //Check whether the Model is created , if yes then use the previous one
        //View Means independent view model
        //myModel = ViewModelProvider(this).get(QuestionModel::class.java)
        myModel = QuestionModel.getInstant()

        tvName.text = myModel.name
        tv.text = myModel.getQuestion()


        //Retrieve the saveState value
//        if(savedInstanceState != null) {
//            tv.text = savedInstanceState?.getString("question")
//        }

        //Button
        btn.setOnClickListener(){
            tv.text = myModel.generateQuestion()
            //tv.text = generateQuestion()
        }
    }

    //Override Function can replace Log.i with black(i), red(e), blue(w)
    override fun onStart(){
        super.onStart()

        Log.i("LifeCycle", "onStart")
    }

    override fun onResume(){
        super.onResume()

        Log.i("LifeCycle", "onResume")
    }

    override fun onStop(){
        super.onStop()

        Log.i("LifeCycle", "onStop")
    }

    override fun onDestroy(){
        super.onDestroy()

        Log.i("LifeCycle", "onDestroy")
    }

    //OnSaveState, Save the value to avoid rotated destroy value, everything stored in memory called Bundle
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//
//        val tv : TextView = findViewById(R.id.tvQuestion)
//        outState.putString("question", tv.text.toString())
//
//    }

    //Function
//    fun generateQuestion() : String{
//        var no1 = (Math.random()*100).toInt()
//        var no2 = (Math.random()*100).toInt()
//
//        return "${no1} + ${no2} = ?"
//    }
}