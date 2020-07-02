package abika.sinau.mahasiswaappabika.repo

import abika.sinau.mahasiswaappabika.model.user.ResponseUserLogin
import abika.sinau.mahasiswaappabika.model.user.ResponseUserRegister
import abika.sinau.mahasiswaappabika.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Abika Chairul Yusri
 * on Monday, 29 June 2020
 * Bismillahirrahmanirrahim
 */
class RepositoryUser {

    fun addData(
        nama: String,
        email: String,
        password: String,
        responseHandler: (ResponseUserRegister) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.userService().register(nama, email, password).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun loginData(
        email: String,
        password: String,
        responseHandler: (ResponseUserLogin) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.userService().login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                responseHandler(response)
            }, { error ->
                errorHandler(error)
            })
    }
}