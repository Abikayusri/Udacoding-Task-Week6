package abika.sinau.mahasiswaappabika.model.user

import abika.sinau.mahasiswaappabika.model.user.DataItemUser
import com.google.gson.annotations.SerializedName

data class ResponseUserLogin(

    @field:SerializedName("data")
	val data: List<DataItemUser?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)