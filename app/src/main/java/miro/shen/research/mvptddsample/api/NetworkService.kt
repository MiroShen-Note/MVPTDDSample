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

    //API 可用效期具有時效性，若 register_success_should_starActivity 測試失敗，則有可能為 API 已失效
    // 請至 run.mocky.io 重新申請新的 API 效期以利測試通過
    const val registerUrl = "https://run.mocky.io/v3/9ee7fbea-dc2b-4663-b6d0-50877d5ab900"
}
class NetworkService {
    var memberAPI: MemberApi

    init {
        val client = OkHttpClient.Builder()
            .connectTimeout(ApiConfig.TIME_OUT_CONNECT.toLong(), TimeUnit.SECONDS)
            .readTimeout(ApiConfig.TIME_OUT_READ.toLong(), TimeUnit.SECONDS)
            .writeTimeout(ApiConfig.TIME_OUT_WRITE.toLong(), TimeUnit.SECONDS)
            //開啟顯示 http log 請在需要 debug 的時候才開啟，使用完畢請關閉顯示 http log
//            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConfig.WEB_HOST)
            .client(client)
            .build()

        memberAPI = retrofit.create(MemberApi::class.java)
    }
}