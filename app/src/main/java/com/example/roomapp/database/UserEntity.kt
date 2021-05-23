package com.example.roomapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "useraccounts")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    var userId : Int = 0,
    var email : String,
    var userName : String,
    var passWord : String


)