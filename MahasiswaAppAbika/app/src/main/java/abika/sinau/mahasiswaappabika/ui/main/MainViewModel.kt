package abika.sinau.mahasiswaappabika.ui.main

import abika.sinau.mahasiswaappabika.model.mahasiswa.ResponseMahasiswaAction
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
    val repository = RepositoryMahasiswa()
    var rDataMhs = MutableLiveData<ResponseMahasiswaData>()
    var rActionMhs = MutableLiveData<ResponseMahasiswaAction>()
    var isError = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()
    var isSuccess = MutableLiveData<Boolean>()

    fun getListDataMhs() {
        isLoading.value = true
        repository.getDataMahasiswa({ response ->
            rDataMhs.value = response
            isLoading.value = false

        }, { error ->
            isError.value = error.localizedMessage
            isLoading.value = false
        })
    }

    fun getHapusDataMhs(id: String){
        isLoading.value = true
        repository.hapusData(id, { response ->
            rActionMhs.value = response
            isSuccess.value = true
            isLoading.value = false

        }, { error ->
            isError.value = error.localizedMessage
            isLoading.value = false
        })
    }
}