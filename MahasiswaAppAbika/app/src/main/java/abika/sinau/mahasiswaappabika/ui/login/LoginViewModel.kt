package abika.sinau.mahasiswaappabika.ui.login

import abika.sinau.mahasiswaappabika.model.user.ResponseUserLogin
import abika.sinau.mahasiswaappabika.repo.RepositoryUser
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Abika Chairul Yusri
 * on Monday, 29 June 2020
 * Bismillahirrahmanirrahim
 */
class LoginViewModel : ViewModel() {
    val repository = RepositoryUser()
    val rLoginUser = MutableLiveData<ResponseUserLogin>()
    var isError = MutableLiveData<String>()
    var isEmpty = MutableLiveData<String>()
    var isSuccess = MutableLiveData<Boolean>()
    var isLoading = MutableLiveData<Boolean>()

    fun getLoginData(email: String, password: String) {
        isLoading.value = true

        when {
            (email.isEmpty() || password.isEmpty()) -> {
                isLoading.value = false
                isEmpty.value = "Data tidak boleh kosong"
            }
            password.length <= 5 -> {
                isError.value = "Password harus lebih dari 5"
            }
            else -> {
                repository.loginData(email, password, { response ->
                    isLoading.value = false
                    rLoginUser.value = response
                    isSuccess.value = true
                }, { error ->
                    isLoading.value = false
                    isError.value = error.localizedMessage
                })
            }
        }
    }
}