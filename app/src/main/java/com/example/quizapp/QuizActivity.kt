package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var questions:ArrayList<QuestionModel>
    private lateinit var binding:ActivityQuizBinding
    private var counter=0
    private var score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        binding=ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questions=ArrayList<QuestionModel>()
        questions.add(QuestionModel("What is the capital of India","New Delhi","Mumbai","Kanpur","Meghalaya","New Delhi"))
        questions.add(QuestionModel("What is the capital of Afghanistan","New Delhi","Kabul","Kerela","Meghalaya","New Delhi"))
        questions.add(QuestionModel("What is the capital of America","New Delhi","Mumbai","Kanpur","Meghalaya","New Delhi"))
        questions.add(QuestionModel("What is the capital of Denmark","New Delhi","Mumbai","Kanpur","Meghalaya","New Delhi"))
        questions.add(QuestionModel("What is the capital of Australia","Melbourne","Mumbai","Kanpur","Meghalaya","Melbourne"))

        binding.questionNumber.text=(counter+1).toString()
        binding.questionText.text=questions.get(counter).question
        binding.option1.text=questions.get(counter).option1
        binding.option2.text=questions.get(counter).option2
        binding.option3.text=questions.get(counter).option3
        binding.option4.text=questions.get(counter).option4

        fun getNextQues(choosenOption:String){

            if(counter<questions.size && choosenOption==questions.get(counter).answer)score++
            counter++
            if(counter==questions.size){
                val intent= Intent(this@QuizActivity,ScoreActivity::class.java)
                intent.putExtra("SCORE",score)
                startActivity(intent)
                finish()
            }
            else {
                binding.questionNumber.text = ("Question ${counter +1}")
                binding.questionText.text = questions.get(counter).question
                binding.option1.text = questions.get(counter).option1
                binding.option2.text = questions.get(counter).option2
                binding.option3.text = questions.get(counter).option3
                binding.option4.text = questions.get(counter).option4
            }

        }
        binding.option1.setOnClickListener{
            getNextQues(questions.get(counter).option1)
        }
        binding.option2.setOnClickListener{
            getNextQues(questions.get(counter).option2)
        }
        binding.option3.setOnClickListener{
            getNextQues(questions.get(counter).option3)
        }
        binding.option4.setOnClickListener {
            getNextQues(questions.get(counter).option4)
        }

    }
}