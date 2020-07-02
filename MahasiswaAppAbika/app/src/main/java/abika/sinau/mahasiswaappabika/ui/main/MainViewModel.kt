package abika.sinau.mahasiswaappabika.ui.main

import abika.sinau.mahasiswaappabika.model.mahasiswa.ResponseMahasiswaData
import abika.sinau.mahasiswaappabika.repo.RepositoryMahasiswa
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Abika Chairul Yusri
 * on Monday, 29 June 2020
 * Bismillahirrahmanirrahim
 */
class MainViewModel : ViewModel() {
    val rMahasiswa = RepositoryMahasiswa()
    var responseDataMhs = MutableLiveData<ResponseMahasiswaData>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getListDataMhs() {
        isLoading.value = true

        rMahasiswa.getDataMahasiswa({ response ->
            responseDataMhs.value = response
            isLoading.value = false

        }, { error ->
            isError.value = error
            isLoading.value = false
        })
    }
}