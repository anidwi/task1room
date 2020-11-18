package com.example.roomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdb.room.Register
import com.example.roomdb.room.RegisterDB
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private val db by lazy { RegisterDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
    }

    private fun setupListener(){
        registerBtn.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.registerDao().addRegister(
                    Register(
                        0,
                        name.text.toString(),
                        email.text.toString(),
                        address.text.toString(),
                        age.text.hashCode(),
                        phone.text.hashCode(),
                        password.text.toString()
                    )
                )
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                finish()
            }
        }
        logintext.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }
}