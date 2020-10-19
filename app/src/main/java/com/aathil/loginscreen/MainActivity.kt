package com.aathil.loginscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.method.PasswordTransformationMethod
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
//        showPass.setOnClickListener { view!, isChecked ->
//            if(isChecked){
//                passwordInput.transformationMethod = null
//            }
//            else{
//                passwordError.transformationMethod = PasswordTransformationMethod()
//            }
//
//        }



//        passwordInput.transformationMethod = null
//        val handler = Handler()
//        handler.postDelayed({reshowPassword()  }, 1000)
////        val timeOut : Long = 10
////        Handler().postDelayed({
////            passwordError.transformationMethod = PasswordTransformationMethod()
////
////        }, timeOut)


    }



    fun reshowPassword(){
        passwordError.transformationMethod = PasswordTransformationMethod()
    }

    fun showPassBtn(view: View){
        startActivity(Intent(this, ForgetPassword::class.java))
    }
}
