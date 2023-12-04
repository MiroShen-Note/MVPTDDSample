package miro.shen.research.mvptddsample.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfig {

    const val WEB_HOST = "https://run.mocky.io/"

    const val TIME_OUT_CONNECT = 30
    const val TIME_OUT_READ = 30
    const val TIME_OUT_WRITE = 30

    const val registerUrl = "https://run.mocky.io/v3/a5b2ee59-c03a-42fe-97d7-0a097da94b68"
}
class NetworkService {
    var memberAPI: MemberApi

    init {
        val client = OkHttpClient.Builder()
            .connectTimeout(ApiConfig.TIME_OUT_CONNECT.toLong(), TimeUnit.SECONDS)
            .readTimeout(ApiConfig.TIME_OUT_READ.toLong(), TimeUnit.SECONDS)
            .writeTimeout(ApiConfig.TIME_OUT_WRITE.toLong(), TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConfig.WEB_HOST)
            .client(client)
            .build()

        memberAPI = retrofit.create(MemberApi::class.java)
    }
}