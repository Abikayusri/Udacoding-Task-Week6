package abika.sinau.mahasiswaappabika.model.mahasiswa

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItemMahasiswa(

    @field:SerializedName("mahasiswa_alamat")
    val mahasiswaAlamat: String? = null,

    @field:SerializedName("mahasiswa_nohp")
    val mahasiswaNohp: String? = null,

    @field:SerializedName("mahasiswa_jurusan")
    val mahasiswaJurusan: String? = null,

    @field:SerializedName("id_mahasiswa")
    val idMahasiswa: String? = null,

    @field:SerializedName("mahasiswa_nama")
    val mahasiswaNama: String? = null,

    @field:SerializedName("mahasiswa_nim")
    val mahasiswaNim: String? = null,

    @field:SerializedName("mahasiswa_semester")
    val mahasiswaSemester: String? = null
) : Parcelable