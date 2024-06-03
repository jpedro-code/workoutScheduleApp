package com.devandroid.workoutschedule.model

import android.os.Parcelable
import com.devandroid.workoutschedule.helper.FirebaseHelper
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exercicio(
    var id : String = "",
    var nome : String = "",
    var descricao : String = "",
    var totalCalorias : String = ""
) : Parcelable{
    init {
        this.id = FirebaseHelper.getDatabase().push().key ?: ""
    }
}
