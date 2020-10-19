package com.aathil.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.emailError
import kotlinx.android.synthetic.main.activity_sign_up.emailInput
import kotlinx.android.synthetic.main.activity_sign_up.passwordInput
import kotlinx.android.synthetic.main.activity_main.passwordError as passwordError1

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    private fun validation(){

        var userName: String = nameInput.text.toString()
        var email: String = emailInput.text.toString()
        var password1 : String = passwordInput.text.toString()
        var password2 : String = password2Input.text.toString()

        //validation
        var isEmailValid : Boolean = email.validEmail()
        var isNameValid: Boolean = userName.nonEmpty()
        var isPassword1Valid: Boolean = password1.nonEmpty()
        var isPassword2Valid: Boolean = password2.nonEmpty()

        //email
        if(isEmailValid){

            emailError.text = " "
        }
        else{

            emailError.text = "Please Insert Valid email"
        }

        //name
        if(isNameValid){

            nameError.text = " "
        }
        else{

            nameError.text = "Please Insert Valid email"
        }

        //password1
        if(isPassword1Valid){
            passwordError.text = ""

        }
        else{

            passwordError.text = "Password Should not be empty"
        }

        //password2
        if(isPassword2Valid){
            password2Error.text = ""

        }
        else{

            password2Error.text = "Password Should not be empty"
        }

        if(isPassword1Valid && isPassword2Valid){
            if(password1 != password2){
                passwordError.text = "Passwords are not matching"
                password2Error.text = "Passwords are not matching"
            }
        }

    }


    fun signUp(view: View){
        validation()
    }
}