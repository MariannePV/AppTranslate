package campalans.m8.apptranslate

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Creem un singleton, per així crear només una instància d'aquesta classe i amb un punt global d'accès a aquesta instància
object API {
    private const val BASE_URL = "https://ws.detectlanguage.com/"

    val retrofitService:ApiService by lazy {
        getRetrofit().create(ApiService::class.java)
    }

    //La funció retorna la instància necessària de Retrofit per començar a fer peticions
    private fun getRetrofit():Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }
}