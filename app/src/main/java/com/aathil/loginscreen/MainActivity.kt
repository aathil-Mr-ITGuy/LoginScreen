package com.aathil.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
    private fun validatePassword(){

        var password:String = passwordInput.text.toString()
        var isPasswordValid: Boolean = password.nonEmpty()

        if(isPasswordValid){
            passwordError.text = ""

        }
        else{

            passwordError.text = "Password Should not be empty"
        }

    }

    fun login(view: View){
        validateEmail()
        validatePassword()
    }

    fun showPass(view: View){
        passwordInput.transformationMethod = null


    }

    class Run {
        companion object {
            fun after(delay: Long, process: () -> Unit) {
                Handler().postDelayed({
                    process()
                }, delay)
            }
        }
    }
}