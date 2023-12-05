package miro.shen.research.mvptddsample

interface RegisterContract {
    interface IRegisterView {
        fun onInputDataError(title: String, message: String)
        fun onRegisterSuccess()
        fun onRegisterFail()

    }

    interface IRegisterPresenter {
        fun register(loginId: String, password: String)

    }


}
