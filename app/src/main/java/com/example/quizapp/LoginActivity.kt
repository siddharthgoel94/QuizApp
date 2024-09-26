package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{
            Firebase.auth.createUserWithEmailAndPassword(binding.email.editText?.text.toString(),
                binding.password.editText?.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this,"USER CREATED SUCCESSFULLY",Toast.LENGTH_LONG).show()
                        val intent= Intent(this,QuizActivity::class.java)
                        startActivity(intent)
                    }
                else{
                        Toast.makeText(this,"USER CAN'T BE CREATED !!!",Toast.LENGTH_LONG).show()
                    }
            }


        }
    }
}