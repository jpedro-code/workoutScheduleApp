package com.devandroid.workoutschedule.helper

import com.devandroid.workoutschedule.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import com.google.firebase.database.ktx.database

class FirebaseHelper {

    companion object{

        fun getDatabase() = FirebaseDatabase.getInstance().reference

        fun getIdUser() = getAuth().uid
        private fun getAuth() = FirebaseAuth.getInstance()

        fun isAuthenticated() = getAuth().currentUser != null

        fun erroValidation(error : String) :Int{
            return when {
                error.contains("The supplied auth credential is incorrect, malformed or has expired.") ->{
                    R.string.account_not_registered_register_fragment
                }
                else -> R.string.error_default
            }
        }

    }

}