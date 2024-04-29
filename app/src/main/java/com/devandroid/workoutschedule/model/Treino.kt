package com.devandroid.workoutschedule.model

import android.os.Parcel
import android.os.Parcelable
import com.devandroid.workoutschedule.helper.FirebaseHelper
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize
data class Treino(
    var id : String = "",
    var nome : String = "",
    var descricao : String = "",
    var data : String = ""
) : Parcelable{
   init {
       this.id = FirebaseHelper.getDatabase().push().key ?: ""
   }


}
