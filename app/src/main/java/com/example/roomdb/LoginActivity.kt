package com.example.roomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdb.room.Register
import com.example.roomdb.room.RegisterDB
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.email
import kotlinx.android.synthetic.main.activity_login.password
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {

    private val db by lazy { RegisterDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupListener()
    }

    private fun setupListener(){
        loginBtn.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.registerDao().getLogin(email.text.toString(), password.text.toString())
                startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
                db.registerDao().getProfile(0)
                finish()
            }
        }
    }
}
