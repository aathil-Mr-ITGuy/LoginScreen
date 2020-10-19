package com.aathil.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_main.*

class ForgetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
    }
    fun goBack(view: View){
        startActivity(Intent(this,MainActivity::class.java))
    }

    private fun validateEmail(){

        var email : String = emailInput.text.toString()
        var isEmailValid = email.validEmail()

        if(isEmailValid){

            emailError.text = " "
        }
        else{

            emailError.text = "Please Insert Valid email"
        }




    }

    fun reset(view: View){
        validateEmail()
    }
}