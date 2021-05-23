package com.example.roomapp.database

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async


class UserRepository (context: Context) {

    private val userDB = UserDatabase.getInstance(context)

     suspend fun insertUser(userEntity: UserEntity) : Long {

        val id = CoroutineScope(Dispatchers.IO).async {
            userDB.getUserDao().createUser(userEntity)
        }
        return id.await()
    }

     suspend fun getUser(name: String, password: String): UserEntity? {
        val user = CoroutineScope(Dispatchers.IO).async {
            val user = userDB.getUserDao().getUsername(name, password)
            user
        }
        return user.await()
    }
}

