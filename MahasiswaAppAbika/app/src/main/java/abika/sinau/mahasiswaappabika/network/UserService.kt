package abika.sinau.mahasiswaappabika.network

import abika.sinau.mahasiswaappabika.model.user.ResponseUserLogin
import abika.sinau.mahasiswaappabika.model.user.ResponseUserRegister
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 17 June 2020
 * Bismillahirrahmanirrahim
 */
interface UserService {
    // implement reactive programming
    @FormUrlEncoded
    @POST("userRegister.php")
    fun register(
        @Field("nama") nama: String,
        @Field("email") email: String,
        @Field("password") password: String
    ):Single<ResponseUserRegister>

    @FormUrlEncoded
    @POST("userLogin.php")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ):Single<ResponseUserLogin>
}