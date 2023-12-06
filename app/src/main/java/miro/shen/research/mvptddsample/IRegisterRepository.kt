package miro.shen.research.mvptddsample

import miro.shen.research.mvptddsample.model.RegisterResponse

interface IRegisterRepository {
    abstract fun register(
        loginId: String,
        passWord: String,
        listener: RegisterCallback)

    interface RegisterCallback {
        abstract fun onRegisterResult(registerResponse: RegisterResponse)

    }

}
