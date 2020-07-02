package abika.sinau.mahasiswaappabika.repo

import abika.sinau.mahasiswaappabika.model.mahasiswa.ResponseMahasiswaAction
import abika.sinau.mahasiswaappabika.model.mahasiswa.ResponseMahasiswaData
import abika.sinau.mahasiswaappabika.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Abika Chairul Yusri
 * on Monday, 29 June 2020
 * Bismillahirrahmanirrahim
 */
class RepositoryMahasiswa {
    fun getDataMahasiswa(
        responseHandler: (ResponseMahasiswaData) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.mahasiswaService().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                responseHandler(response)
            }, { error ->
                errorHandler(error)
            })
    }

    fun tambahData(
        nim: String,
        nama: String,
        nohp: String,
        jurusan: String,
        semester: String,
        alamat: String,
        responseHandler: (ResponseMahasiswaAction) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.mahasiswaService().insertData(nim, nama, nohp, jurusan, semester, alamat)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                responseHandler(response)
            }, { error ->
                errorHandler(error)
            })
    }

    fun updateData(
        id: String,
        nim: String,
        nama: String,
        nohp: String,
        jurusan: String,
        semester: String,
        alamat: String,
        responseHandler: (ResponseMahasiswaAction) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.mahasiswaService().updateData(id, nim, nama, nohp, jurusan, semester, alamat)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                responseHandler(response)
            }, { error ->
                errorHandler(error)
            })
    }

    fun hapusData(
        id: String,
        responseHandler: (ResponseMahasiswaAction) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        val hapus = ConfigNetwork.mahasiswaService().deleteData(id ?: "")
        hapus.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                responseHandler(response)
            }, { error ->
                errorHandler(error)
            })
    }
}