package abika.sinau.mahasiswaappabika.model.user

import com.google.gson.annotations.SerializedName

data class DataItemUser(

	@field:SerializedName("user_nama")
	val userNama: String? = null,

	@field:SerializedName("user_email")
	val userEmail: String? = null,

	@field:SerializedName("user_password")
	val userPassword: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null
)