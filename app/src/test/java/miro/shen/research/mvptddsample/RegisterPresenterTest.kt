package miro.shen.research.mvptddsample

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class RegisterPresenterTest {
    lateinit var presenter: RegisterContract.IRegisterPresenter

    @MockK(relaxed = true)
    lateinit var view : RegisterContract.IRegisterView

    @MockK(relaxed = true)
    lateinit var repository :IRegisterRepository

    @Before
    fun setup(){
        MockKAnnotations.init(this)
        presenter = RegisterPresenter(view, repository)
    }

    @Test
    fun registerWrongId() {
        presenter.register("1111", "2222")
        verify { view.onInputDataError(eq("錯誤"),eq("帳號至少要6碼，第1碼為英文")) }
    }

    @Test
    fun registerWrongPassword() {
        presenter.register("A11111111", "2222")
        verify { view.onInputDataError(eq("錯誤"),eq("密碼至少要8碼，第1碼為英文，並包含1碼數字")) }
    }

    @Test
    fun registerSuccess(){
        val loginId = "A11111111"
        val password = "A2222222"

        val slot = slot<IRegisterRepository.RegisterCallback>()
        every { repository.register(eq(loginId), eq(password), capture(slot))}
            .answers {
                slot.captured.onRegisterResult(
                    RegisterResponse(true, "AnyId")
                )
            }

        presenter.register(loginId, password)

        verify{ view.onRegisterSuccess() }
    }

}