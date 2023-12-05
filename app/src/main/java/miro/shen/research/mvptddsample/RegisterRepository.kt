package miro.shen.research.mvptddsample

import androidx.test.espresso.idling.CountingIdlingResource
import miro.shen.research.mvptddsample.api.MemberApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Idling{
    val idlingResource = CountingIdlingResource("API")
}
class RegisterRepository(val api: MemberApi) : IRegisterRepository {
    override fun register(
        loginId: String,
        passWord: String,
        listener: IRegisterRepository.RegisterCallback
    ) {
        Idling.idlingResource.increment()

        val request = RegisterRequest(loginId, passWord)
        api.register(request).enqueue(object: Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                //success
                println("response:$response")
                if(response.isSuccessful){
                    //200
                    listener.onRegisterResult(response.body()!!)
                    Idling.idlingResource.decrement()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                //TODO
            }
        })
    }

}
