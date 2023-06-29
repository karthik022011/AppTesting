package com.kartheek.apptesting

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kartheek.apptesting.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.etPassword.addTextChangedListener(textWatcher)
        binding.buttonLogin.setOnClickListener {
            if (binding.etUserName.text.isNotEmpty() && binding.etPassword.text.length >= 6) {
                startActivity(Intent(this@MainActivity, WelcomeActivity::class.java))
            } else {
                Toast.makeText(this, "Login failed, try again", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // textWatcher is for watching any changes in editText
    var textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            // this function is called before text is edited
        }
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            // this function is called when text is edited
            if(s.length>=6){
                binding.tvErrorMessage.visibility = View.GONE
            }else{
                binding.tvErrorMessage.visibility = View.VISIBLE
            }
        }
        override fun afterTextChanged(s: Editable) {
            // this function is called after text is edited
        }
    }
}