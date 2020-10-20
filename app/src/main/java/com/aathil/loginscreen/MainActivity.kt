package com.aathil.loginscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showPassword.setOnClickListener(View.OnClickListener {
            if (showPassword.isChecked) {
                passwordInput.transformationMethod = null
            } else {
                passwordInput.transformationMethod = PasswordTransformationMethod()
            }
        })
    }

    // email and password validation
    private fun String.isEmptyEmail() =
            !TextUtils.isEmpty(this)

    private fun String.isValidEmail() =
             Patterns.EMAIL_ADDRESS.matcher(this).matches()

    private fun String.isValidPassword() =
            !TextUtils.isEmpty(this)


    private fun validateEmail(){

        var email : String = emailInput.text.toString()

        var isEmailValid = email.isValidEmail()
        var isEmailEmpty = email.isEmptyEmail()

        if(isEmailEmpty){
            if(isEmailValid){

                emailError.text = " "
            }else{
                emailError.text = "Please Insert Valid email"
            }
        } else{

            emailError.text = "Email Should not be empty"
        }


    }
    private fun validatePassword(){

        var password:String = passwordInput.text.toString()
        var isPasswordValid: Boolean = password.isValidPassword()

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


    fun showPassBtn(view: View){
        startActivity(Intent(this, ForgetPassword::class.java))
    }

    fun signUp(view: View){
        startActivity(Intent(this, SignUp::class.java))
    }
}
