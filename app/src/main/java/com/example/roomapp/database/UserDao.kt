package com.example.roomapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {

    @Insert
    fun createUser(userEntity: UserEntity) : Long

    @Query("SELECT * FROM useraccounts WHERE email = :email AND password = :password")
    fun getUsername(email: String, password: String): UserEntity?
}