package com.example.tamrinsixthq1

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import com.example.tamrinsixthq1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences:SharedPreferences
    private var ref="ref"
    private var store="store"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=getSharedPreferences(ref, MODE_PRIVATE)
    }

     fun setInfo(view: View){
         if (view is RadioButton){
             if (checkGender(view,"Female")){
                 setResultOfGender("Female")
             }
             if (checkGender(view,"Male")){
                 setResultOfGender("Male")
             }
         }
        if (view==binding.buttonRegister){
            binding.textViewFullName.text=binding.editTextTextPersonName.text
            binding.textViewUserName.text=binding.editTextTextUserName.text
            binding.textViewEmail.text=binding.editTextTextEmailAddress.text
            binding.textViewPassword.text=binding.editTextTextPassword.text
          sharedPreferences.edit()
        }
    }
     fun clickButtonInfo(view: View){
        if (view==binding.buttonShowInfo){}
        if (view==binding.buttonHideInfo){}
    }
    private fun setResultOfGender(gender:String){
        binding.textViewGender.text=gender
    }
     fun checkGender(radioButton: RadioButton,s:String):Boolean =radioButton.text==s
}