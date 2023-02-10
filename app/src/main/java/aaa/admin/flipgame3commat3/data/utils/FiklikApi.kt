package aaa.admin.flipgame3commat3.data.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FiklikApi {

    operator fun invoke() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://65.109.10.118/games/FlipGame3ComMat3/")
        .build()
        .create(FikilikServise::class.java)

}