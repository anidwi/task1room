package com.example.roomdb.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Register (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val email: String,
    val address: String,
    val age: Int,
    val phone: Int,
    val password: String
)