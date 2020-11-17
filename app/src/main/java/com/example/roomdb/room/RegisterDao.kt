package com.example.roomdb.room

import androidx.room.*

@Dao
interface RegisterDao {

    @Insert
    suspend fun addRegister(register: Register)

    @Update
    suspend fun updateRegister(register: Register)

    @Delete
    suspend fun deleteRegister(register: Register)

    @Query("SELECT * FROM register")
    suspend fun getRegister(): List<Register>

    @Query("SELECT * FROM register WHERE email= :email AND password= :password")
    suspend fun getLogin( email: String, password: String ): List<Register>

    @Query("SELECT * FROM register WHERE id= :id")
    suspend fun getProfile( id: Int ): List<Register>

}