package abika.sinau.mahasiswaappabika.ui.register

import abika.sinau.mahasiswaappabika.model.user.ResponseUserLogin
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
    var rRegistData = MutableLiveData<ResponseUserRegister>()
    var isErrorRegist = MutableLiveData<Throwable>()
    var isEmpty = MutableLiveData<Boolean>()
    var isLoading = MutableLiveData<Boolean>()

    fun getRegistData(nama: String, email: String, password: String){
        if (nama.isEmpty() || email.isEmpty() || password.isEmpty()){
            isEmpty.value = true
        } else {
//            repository.addData
        }
    }
}