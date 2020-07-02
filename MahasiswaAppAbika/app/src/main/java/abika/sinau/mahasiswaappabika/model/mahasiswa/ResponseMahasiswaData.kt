package abika.sinau.mahasiswaappabika.model.mahasiswa

import com.google.gson.annotations.SerializedName

data class ResponseMahasiswaData(

    @field:SerializedName("data")
	val data: List<DataItemMahasiswa?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)