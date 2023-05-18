package com.example.myapplication

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random.Default.nextInt
import android.content.Context


class MainActivity : AppCompatActivity(),OnClick {

    lateinit var recyclerView: RecyclerView
    lateinit var arrayList: ArrayList<Alphabet>

    var  first  = 1
    var health=3;
    var  second  = 1
    var  third  = 1
    var word="";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         word = intent.getStringExtra("word").toString()
        val clue = intent.getStringExtra("clue")
        Log.d("arraly",word.toString().trim())
        val edit_text1 = findViewById<EditText>(R.id.edit_1)
        val edit_text2 = findViewById<EditText>(R.id.edit_2)
        val edit_text3 = findViewById<EditText>(R.id.edit_3)
        val edit_text4 = findViewById<EditText>(R.id.edit_4)
        val edit_text5 = findViewById<EditText>(R.id.edit_5)

        var arrayLists = word.toString().trim().split("")

        Log.d("arraly",arrayLists[0].toString())




        btnInfoImage.setOnClickListener {

            val dialog = Dialog(this)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialog.setCancelable(true)
            dialog.setContentView(R.layout.custom_layout)
            val window: Window =getWindow()
            val wlp = window.attributes

            val body = dialog.findViewById(R.id.btnOk) as Button
            var text=dialog.findViewById(R.id.text) as TextView
            text.setText(clue.toString())
            body.setOnClickListener {
                dialog.cancel()
            }

            dialog.show()
            dialog.getWindow()?.setGravity(Gravity.TOP);


        }
        Reset.setOnClickListener {
            edit_text1.getText().clear();
            edit_text2.getText().clear();
            edit_text3.getText().clear();
            edit_text4.getText().clear();
            edit_text5.getText().clear();
            Toast.makeText(this, "Reset Successfully!", Toast.LENGTH_LONG).show()

        }
        check.setOnClickListener {



            val input1 = edit_text1.text.toString()
            val input2 = edit_text2.text.toString()
            val input3 = edit_text3.text.toString()
            val input4 = edit_text4.text.toString()
            val input5 = edit_text5.text.toString()
            val output = "$input1$input2$input3$input4$input5"
            if(input1.equals("")){
                Toast.makeText(this, "Add text first", Toast.LENGTH_LONG).show()

            }else if(input2.equals("")){
                Toast.makeText(this, "Add text first", Toast.LENGTH_LONG).show()
            }else if(input3.equals("")){
                Toast.makeText(this, "Add text first", Toast.LENGTH_LONG).show()

            }else if(input4.equals("")){
                Toast.makeText(this, "Add text first", Toast.LENGTH_LONG).show()
            }else if(input5.equals("")){
                    Toast.makeText(this, "Add text first", Toast.LENGTH_LONG).show()
                }
            else {

                if (output.equals(word.take(5))) {
                    Toast.makeText(this, "Hurray You Won !", Toast.LENGTH_LONG).show()

                    val sharedPreferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    val score = sharedPreferences.getInt("score", 0)

                    editor.putInt("score", score+1)
                    editor.apply()
                    val intent = Intent(this, Login::class.java)


                    startActivity(intent)


                } else if (health == 1) {
                    val dialog = Dialog(this)
                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    dialog.setCancelable(true)
                    dialog.setContentView(R.layout.game_over)
                    val btnHome = dialog.findViewById(R.id.btnHome) as Button
                    val PlayAgain = dialog.findViewById(R.id.PlayAgain) as Button
                    val score = dialog.findViewById(R.id.score) as TextView
                    val sharedPreferencess = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
                    val scores = sharedPreferencess.getInt("score", 0)

                    score.setText("Score "+scores+" points")

                    btnHome.setOnClickListener {
                        val intent = Intent(this, Login::class.java)


                        startActivity(intent)

                        // Do some work here


                    }
                    PlayAgain.setOnClickListener {
                        val intent = Intent(this, Login::class.java)


                        startActivity(intent)

                        // Do some work here


                    }
                    dialog.getWindow()?.setGravity(Gravity.TOP);

                    dialog.show()

                } else {
                    health = health - 1
                    udateIcnosColor()
                    Toast.makeText(this, "You Lost Loosed One Heart", Toast.LENGTH_LONG).show()
                    edit_text1.getText().clear();
                    edit_text2.getText().clear();
                    edit_text3.getText().clear();
                    edit_text4.getText().clear();
                    edit_text5.getText().clear();

                }
            }
//            else {
//                val dialog = Dialog(this)
//                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//                dialog.setCancelable(true)
//                dialog.setContentView(R.layout.game_over)
//                val btnHome = dialog.findViewById(R.id.btnHome) as Button
//                val PlayAgain = dialog.findViewById(R.id.PlayAgain) as Button
//                btnHome.setOnClickListener{
//                        val intent = Intent(this, Login::class.java)
//
//
//                        startActivity(intent)
//
//                        // Do some work here
//
//
//                }
//                PlayAgain.setOnClickListener{
//                        val intent = Intent(this, Login::class.java)
//
//
//                        startActivity(intent)
//
//                        // Do some work here
//
//
//                }
//                dialog.getWindow()?.setGravity(Gravity.TOP);
//
//                dialog.show()
//            }

        }





        arrayList = ArrayList()
        arrayList?.add(Alphabet(arrayLists[1], false))
        arrayList?.add(Alphabet(arrayLists[5], false))
        arrayList?.add(Alphabet(arrayLists[8], false))
        arrayList?.add(Alphabet(arrayLists[9], false))
        arrayList?.add(Alphabet(arrayLists[10], false))
        arrayList?.add(Alphabet(arrayLists[6], false))

        arrayList?.add(Alphabet(arrayLists[12], false))
        arrayList?.add(Alphabet(arrayLists[4], false))

        arrayList?.add(Alphabet(arrayLists[2], false))
        arrayList?.add(Alphabet(arrayLists[7], false))
        arrayList?.add(Alphabet(arrayLists[11], false))

        arrayList?.add(Alphabet(arrayLists[13], false))
        arrayList?.add(Alphabet(arrayLists[14], false))
        arrayList?.add(Alphabet(arrayLists[3], false))

        arrayList?.add(Alphabet(arrayLists[15], false))




//        Log.d("arraly",arrayLists.toString())
//
//        for (i in 1 until arrayLists.size) {
//            val item = arrayLists[i]
//            println(item)
//            arrayList?.add(Alphabet(item
//                , false))
//
//        }
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL)
        recyclerView?.layoutManager = staggeredGridLayoutManager
        val adapter = Adapter(this@MainActivity, arrayList!!,this)
        recyclerView?.adapter = adapter
    }


    private fun udateIcnosColor() {
        if(health==2){
            heartThird.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);

        }
        if(health==1){
            heartSecond.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);

        }
        if(health==0){
            heartFirst.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);

        }
    }

    override fun onClik(position: Int) {
        Log.d("datdd",word)

        var arrayLists = word.toString().trim().split("")
        Log.d("datdd", edit_1.text.toString());
        var main1=edit_1.text.toString();
        var main2=edit_2.text.toString();
        var main3=edit_3.text.toString();
        var main4=edit_4.text.toString();
        var main5=edit_5.text.toString();

        if(main1.equals("")){
            edit_1.setText(arrayLists[position+1])
            Log.d("datdd",arrayLists[position+1])

        }else
        if(main2.equals("")){
            edit_2.setText(arrayLists[position+1])
        }else
        if(main3.equals("")){
            edit_3.setText(arrayLists[position+1])
        }else
        if(main4.equals("")){
            edit_4.setText(arrayLists[position+1])
        }else
        if(main5.equals("")){
            edit_5.setText(arrayLists[position+1])
        }

//        if(position==0){
//            edit_1.setText(arrayLists[1])
//            Log.d("datdd",arrayLists[1])
//        }
//        if(position==1){
//            edit_2.setText(arrayLists[2])
//        }
//        if(position==2){
//            edit_3.setText(arrayLists[3])
//        }
//        if(position==3){
//            edit_4.setText(arrayLists[4])
//        }
//        if(position==4){
//            edit_5.setText(arrayLists[5])
//        }


    }
    fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}