package aaa.admin.flipgame3commat3.data.utils

import aaa.admin.flipgame3commat3.data.model.Fiklik
import aaa.admin.flipgame3commat3.data.model.Fiklikg
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface FikilikServise {

    @POST("fiklik.php")
    suspend fun getFiklikg(@Body fiklik: Fiklik): Response<Fiklikg>

    @POST("fiklikr.php")
    suspend fun setFiklikr(@Body fiklikr: JSONObject)

}