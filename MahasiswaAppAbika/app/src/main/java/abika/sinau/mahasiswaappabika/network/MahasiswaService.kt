package abika.sinau.mahasiswaappabika.network

import abika.sinau.mahasiswaappabika.model.mahasiswa.ResponseMahasiswaAction
import abika.sinau.mahasiswaappabika.model.mahasiswa.ResponseMahasiswaData
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 18 June 2020
 * Bismillahirrahmanirrahim
 */
interface MahasiswaService {

    //Get Data
    @GET("getData.php")
    fun getData(): Flowable<ResponseMahasiswaData>

    //Insert Data
    @FormUrlEncoded
    @POST("insertData.php")
    fun insertData(
        @Field("nim") nim: String,
        @Field("nama") nama: String,
        @Field("nohp") nohp: String,
        @Field("jurusan") jurusan: String,
        @Field("semester") semester: String,
        @Field("alamat") alamat: String
    ): Single<ResponseMahasiswaAction>

    //Update Data
    @FormUrlEncoded
    @POST("updateData.php")
    fun updateData(
        @Field("id") id: String,
        @Field("nim") nim: String,
        @Field("nama") nama: String,
        @Field("nohp") nohp: String,
        @Field("jurusan") jurusan: String,
        @Field("semester") semester: String,
        @Field("alamat") alamat: String
    ): Single<ResponseMahasiswaAction>

    @FormUrlEncoded
    @POST("deleteData.php")
    fun deleteData(
        @Field("id") id: String
    ): Single<ResponseMahasiswaAction>
}