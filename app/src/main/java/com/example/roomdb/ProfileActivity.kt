package com.example.roomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.roomdb.room.RegisterDB
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProfileActivity : AppCompatActivity() {

    private val db by lazy { RegisterDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupListener()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val register = db.registerDao().getRegister()
            Log.d("Profile", "dbresponse: $register")
        }
    }

    private fun setupListener(){
        logoutBtn.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, RegisterActivity::class.java))
        }
    }

}