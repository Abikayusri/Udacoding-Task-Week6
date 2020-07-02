package abika.sinau.mahasiswaappabika.ui.action

import abika.sinau.mahasiswaappabika.model.mahasiswa.ResponseMahasiswaAction
import abika.sinau.mahasiswaappabika.repo.RepositoryMahasiswa
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Abika Chairul Yusri
 * on Monday, 29 June 2020
 * Bismillahirrahmanirrahim
 */

class ActionViewModel : ViewModel() {
    val repository = RepositoryMahasiswa()
    var rActionMhs = MutableLiveData<ResponseMahasiswaAction>()
    var isError = MutableLiveData<String>()
    var isStatus = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()
    var isSuccess = MutableLiveData<Boolean>()

    fun getAddDataMhs(
        nim: String,
        nama: String,
        nohp: String,
        jurusan: String,
        semester: String,
        alamat: String
    ) {
        isLoading.value = true
        when {
            (nim.isEmpty() || nama.isEmpty() || nohp.isEmpty() || jurusan.isEmpty() || semester.isEmpty() || alamat.isEmpty()) -> {
                isLoading.value = false
                isError.value = "Data tidak boleh kosong"
            }
            nohp.length < 12 -> {
                isLoading.value = false
                isError.value = "Nomor HP kurang lengkap"
            }
            semester.toInt() > 14 -> {
                isLoading.value = false
                isError.value = "Semester tidak bisa lebih dari 14"
            }
            else -> {
                isLoading.value = false
                repository.tambahData(nim, nama, nohp, jurusan, semester, alamat, { response ->
                    isLoading.value = false
                    rActionMhs.value = response
                    isStatus.value = "Sukses menambahkan data"
                    isSuccess.value = true
                }, { error ->
                    isLoading.value = false
                    isError.value = error.localizedMessage
                })
            }
        }
    }

    fun getUpdateDataMhs(
        id: String?,
        nim: String,
        nama: String,
        nohp: String,
        jurusan: String,
        semester: String,
        alamat: String
    ) {
        isLoading.value = true
        when {
            (nim.isEmpty() || nama.isEmpty() || nohp.isEmpty() || jurusan.isEmpty() || semester.isEmpty() || alamat.isEmpty()) -> {
                isLoading.value = false
                isError.value = "Data tidak boleh kosong"
            }
            nohp.length < 12 -> {
                isLoading.value = false
                isError.value = "Nomor HP kurang lengkap"
            }
            semester.toInt() > 14 -> {
                isLoading.value = false
                isError.value = "Semester tidak bisa lebih dari 14"
            }
            else -> {
                repository.updateData(
                    id ?: "",
                    nim,
                    nama,
                    nohp,
                    jurusan,
                    semester,
                    alamat,
                    { response ->
                        isLoading.value = false
                        rActionMhs.value = response
                        isStatus.value = "Sukses update data"
                        isSuccess.value = true
                    },
                    { error ->
                        isLoading.value = false
                        isError.value = error.localizedMessage
                    })
            }
        }
    }
}