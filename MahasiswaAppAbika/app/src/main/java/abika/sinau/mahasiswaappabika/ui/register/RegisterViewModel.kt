package abika.sinau.mahasiswaappabika.ui.register

import abika.sinau.mahasiswaappabika.model.user.ResponseUserRegister
import abika.sinau.mahasiswaappabika.repo.RepositoryUser
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Abika Chairul Yusri
 * on Monday, 29 June 2020
 * Bismillahirrahmanirrahim
 */
class RegisterViewModel : ViewModel() {
    val repository = RepositoryUser()
    var rRegistUser = MutableLiveData<ResponseUserRegister>()
    var isError = MutableLiveData<String>()
    var isEmpty = MutableLiveData<String>()
    var isSuccess = MutableLiveData<Boolean>()
    var isLoading = MutableLiveData<Boolean>()

    fun getRegistData(nama: String, email: String, password: String, passConf: String) {
        isLoading.value = true

        when {
            (nama.isEmpty() || email.isEmpty() || password.isEmpty() || passConf.isEmpty()) -> {
                isLoading.value = false
                isEmpty.value = "Data tidak boleh kosong"
            }
            password != passConf -> {
                isLoading.value = false
                isError.value = "Password tidak cocok"
            }
            password.length <= 5 -> {
                isLoading.value = false
                isError.value = "Password harus lebih dari 5 karakter"
            }
            else -> {
                repository.addData(nama, email, password, { response ->
                    if (response.isSuccess ?: false) {
                        isLoading.value = false
                        rRegistUser.value = response
                        isSuccess.value = true
                    } else {
                        isLoading.value = false
                        isEmpty.value = "Data tidak boleh kosong"
                    }
                }, { error ->
                    isLoading.value = false
                    isError.value = error.localizedMessage
                })
            }
        }
    }
}