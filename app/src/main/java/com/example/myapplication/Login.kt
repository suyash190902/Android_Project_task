package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val word = findViewById<EditText>(R.id.word)
        val clue = findViewById<EditText>(R.id.clue)

        btnStart.setOnClickListener {
            Log.d("sadsd", word.text.toString().length.toString());
            if (word.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Please Enter !", Toast.LENGTH_LONG).show()

                // EditText is empty
            } else {
                if(word.text.toString().length>5){
                    Toast.makeText(this, "Please Enter text or Enter word with length 5 ", Toast.LENGTH_LONG).show()

                }else if(word.text.toString().length<5){
                    Toast.makeText(this, "Please Enter text or Enter word with length 5 ", Toast.LENGTH_LONG).show()

                }
                else if(word.text.toString().length<4){
                    Toast.makeText(this, "Please Enter text or Enter word with length 5 ", Toast.LENGTH_LONG).show()

                }else if(word.text.toString().contains(" ")){
                    Toast.makeText(this, "Please Enter text Without spaces ", Toast.LENGTH_LONG).show()

                }
                else {
                    if (clue.text.toString().isEmpty()) {
                        Toast.makeText(this, "Please Enter text!", Toast.LENGTH_LONG).show()

                        // EditText is empty
                    } else {
                        val intent = Intent(this, MainActivity::class.java)

                        intent.putExtra("word", word.text.toString()+getRandomString(11))
                        intent.putExtra("clue", clue.text.toString())


                        startActivity(intent)
                        // EditText is not empty
                    }
                }







                // EditText is not empty
            }











        }
    }
    fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}