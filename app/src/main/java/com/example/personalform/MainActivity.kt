package com.example.personalform

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.personalform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonRegister.setOnClickListener {
            register()
        }
        binding.buttonShowInfo.setOnClickListener {
            showInfo()

        }
        binding.button3.setOnClickListener {
            hideInfo()
        }
    }
    fun register(){
        var infoSharedPreferences="info"
        var sharedPreferences: SharedPreferences =getSharedPreferences(infoSharedPreferences,0)

            var shareEditore : SharedPreferences.Editor = sharedPreferences.edit()
            shareEditore.putString("fullName",binding.editTexeFullName.text.toString())
            shareEditore.putString("userName",binding.editTextUserName.text.toString())
            shareEditore.putString("Email",binding.editTextEmail.text.toString())
            shareEditore.putString("password",binding.editTextpassword.text.toString())
            shareEditore.putString("ReTypepassword",binding.editTextReTypepassWord.text.toString())
            if(binding.radioBtnFmail.isChecked==true){
                shareEditore.putString("Gender",binding.radioBtnFmail.text.toString())
            }else if(binding.radioBtnMail.isChecked==true){
                shareEditore.putString("Gender",binding.radioBtnMail.text.toString())
            }
            shareEditore.apply()
            shareEditore.commit()
            Toast.makeText(this,"Information saved successfully", Toast.LENGTH_SHORT).show()
    }
    fun showInfo(){
        val infoSharedPreferences="info"
        val sharedPreferences: SharedPreferences =getSharedPreferences(infoSharedPreferences,0)
        val fullName= sharedPreferences.getString("fullName","Full Name")
        val userName= sharedPreferences.getString("userName","User Name")
        val email= sharedPreferences.getString("Email","email")
        val password= sharedPreferences.getString("password","Pass Word")
        val ReTypepassword= sharedPreferences.getString("ReTypepassword","Sorry, no password entered")
        val gender= sharedPreferences.getString("Gender","gender")
        binding.editTextFullNameShow.visibility= View.VISIBLE
        binding.editTextFullNameShow.setText(fullName).toString()
        binding.editTextUsernameShow.visibility= View.VISIBLE
        binding.editTextUsernameShow.setText(userName).toString()
        binding.editTextEmailShow.visibility= View.VISIBLE
        binding.editTextEmailShow.setText(email).toString()
        if (password.toString()==ReTypepassword.toString()){
            binding.editTextPasswordShow.visibility= View.VISIBLE
            binding.editTextEmailShow.setText(password).toString()
        }else{
            binding.editTextpassword.error="The values entered are not equal"
        }
        binding.editTextGenderShow.visibility= View.VISIBLE
        binding.editTextGenderShow.setText(gender).toString()
    }
    fun hideInfo(){
        binding.editTextFullNameShow.visibility= View.GONE
        binding.editTextUsernameShow.visibility= View.GONE
        binding.editTextEmailShow.visibility= View.GONE
        binding.editTextPasswordShow.visibility= View.GONE
        binding.editTextGenderShow.visibility= View.GONE
    }
}