package miro.shen.research.mvptddsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import miro.shen.research.mvptddsample.api.MemberApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterRepositoryTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK(relaxed = true)
    private lateinit var api: MemberApi

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }

    @Test
    fun registerSuccess(){
        val loginid = "A11111111"
        val password = "A2222222"

        val registerResponse = RegisterResponse(
            true,
            "AnyId"
        )

        val registerRequest = RegisterRequest(
            loginid,
            password
        )

        val response: Response<RegisterResponse> = Response.success(registerResponse)
        val mockkCall = mockk<Call<RegisterResponse>>(relaxed = true)

        val slot = slot<Callback<RegisterResponse>>()

        every{ api.register(any()).enqueue(capture(slot)) }
            .answers {
                slot.captured.onResponse(mockkCall, response)
            }

        val repositoryCallback = mockk<IRegisterRepository.RegisterCallback>(relaxed = true)
        val repository = RegisterRepository(api)
        repository.register(loginid, password, repositoryCallback)

        verify{ api.register(eq(registerRequest))}
        verify { repositoryCallback.onRegisterResult(registerResponse) }
    }
}