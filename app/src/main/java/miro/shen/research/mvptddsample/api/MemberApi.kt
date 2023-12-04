package miro.shen.research.mvptddsample.api

import miro.shen.research.mvptddsample.RegisterRequest
import miro.shen.research.mvptddsample.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MemberApi {
    @POST(ApiConfig.registerUrl)
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>

}
