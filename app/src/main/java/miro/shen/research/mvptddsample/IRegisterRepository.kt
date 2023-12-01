package miro.shen.research.mvptddsample

interface IRegisterRepository {
    abstract fun register(
        loginId: String,
        passWord: String,
        listener: RegisterCallback)

    interface RegisterCallback {
        abstract fun onRegisterResult(registerResponse: RegisterResponse)

    }

}
