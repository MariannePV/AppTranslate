package campalans.m8.apptranslate

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @GET("/0.2/languages")
    //Totes les trucades des d'una corrutina, han de portar suspend
    suspend fun getLanguages(): Response<List<Language>>

    @Headers("Authorization: Bearer 1b462be123b38ef7eefaf8526521a92d")
    @FormUrlEncoded
    @POST("/0.2/detect")
    suspend fun getTextLanguage(@Field("q") text:String):Response<DetectionResponse>
}