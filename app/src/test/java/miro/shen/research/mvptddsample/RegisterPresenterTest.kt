package miro.shen.research.mvptddsample

import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class RegisterPresenterTest {

    @Test
    fun registerWrongId() {
        val view = mockk<RegisterContract.IRegisterView>(relaxed = true)
        val presenter: RegisterContract.IRegisterPresenter = RegisterPresenter(view)
        presenter.register("1111", "2222")
        verify { view.onInputDataError(eq("錯誤"),eq("帳號至少要6碼，第1碼為英文")) }
    }

}