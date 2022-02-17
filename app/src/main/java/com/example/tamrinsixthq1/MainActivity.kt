package com.example.tamrinsixthq1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.tamrinsixthq1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
     lateinit var sharedPreferences:SharedPreferences
     private var fileName=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.textViewFullName.isVisible=false
       binding.textViewUserName.isVisible=false
       binding.textViewEmail.isVisible=false
       binding.textViewPassword.isVisible=false
       binding.textViewGender.isVisible=false
        binding.buttonHideInfo.isVisible=false
    }

     fun setInfo(view: View){
         sharedPreferences=getSharedPreferences(fileName,0)
         var editor=sharedPreferences.edit()
         editor.putString("FullName",binding.editTextTextPersonName.text.toString())
         editor.putString("UserName",binding.editTextTextUserName.text.toString())
         editor.putString("Email",binding.editTextTextEmailAddress.text.toString())
         editor.putString("Password",binding.editTextTextPassword2.text.toString())
         editor.putString("Gender",binding.textViewGender.text.toString())
         editor.putBoolean("buGender", binding.radioButton.isChecked())
         editor.commit()
         Toast.makeText(this,"Info Saved",Toast.LENGTH_SHORT).show()
    }
     fun clickButtonInfo(view: View){
        if (view==binding.buttonShowInfo){
            sharedPreferences=getSharedPreferences(fileName,0)
            binding.textViewFullName.text=sharedPreferences.getString("FullName","")
            binding.textViewUserName.text=sharedPreferences.getString("UserName","")
            binding.textViewEmail.text=sharedPreferences.getString("Email","")
            binding.textViewPassword.text=sharedPreferences.getString("Password","")
            binding.textViewGender.text=sharedPreferences.getString("Gender","")
            if (sharedPreferences.getBoolean("buGender",true)){
                binding.textViewGender.text="Female"
            }else{
                binding.textViewGender.text="Male"
            }
            binding.textViewFullName.isVisible=true
            binding.textViewUserName.isVisible=true
            binding.textViewEmail.isVisible=true
            binding.textViewPassword.isVisible=true
            binding.textViewGender.isVisible=true
            binding.buttonHideInfo.isVisible=true
        }
        if (view==binding.buttonHideInfo){
            binding.textViewFullName.isVisible=false
            binding.textViewUserName.isVisible=false
            binding.textViewEmail.isVisible=false
            binding.textViewPassword.isVisible=false
            binding.textViewGender.isVisible=false
            binding.buttonHideInfo.isVisible=false
        }
    }
}