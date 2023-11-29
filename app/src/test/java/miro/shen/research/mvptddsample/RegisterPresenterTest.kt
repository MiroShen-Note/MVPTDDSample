package miro.shen.research.mvptddsample

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class RegisterPresenterTest {
    lateinit var presenter: RegisterContract.IRegisterPresenter

    @MockK(relaxed = true)
    lateinit var view : RegisterContract.IRegisterView

    @Before
    fun setup(){
        MockKAnnotations.init(this)
        presenter = RegisterPresenter(view)
    }

    @Test
    fun registerWrongId() {
        presenter.register("1111", "2222")
        verify { view.onInputDataError(eq("錯誤"),eq("帳號至少要6碼，第1碼為英文")) }
    }

}