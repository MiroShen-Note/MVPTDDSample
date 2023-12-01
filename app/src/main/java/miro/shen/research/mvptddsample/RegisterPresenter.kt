package miro.shen.research.mvptddsample

class RegisterPresenter(
    val view: RegisterContract.IRegisterView,
    val repository: IRegisterRepository
) :
    RegisterContract.IRegisterPresenter {
    override fun register(loginId: String, password: String) {

        if (!loginVerify(loginId)) {
            view.onInputDataError("錯誤", "帳號至少要6碼，第1碼為英文")
        } else if (!passwordVerify(password)) {
            view.onInputDataError("錯誤", "密碼至少要8碼，第1碼為英文，並包含1碼數字")
        } else {
            repository.register(loginId, password, object : IRegisterRepository.RegisterCallback {
                override fun onRegisterResult(response: RegisterResponse) {
                    if (response.registerResult) {
                        view.onRegisterSuccess()
                    }
                }
            })

        }
    }

    private fun passwordVerify(password: String): Boolean {
        var isPwdOK = false
        if (password.length >= 8) {
            if (password.uppercase().first() in 'A'..'Z') {
                if (password.findAnyOf((0..9).map { it.toString() }) != null) {
                    isPwdOK = true
                }
            }
        }
        return isPwdOK
    }

    private fun loginVerify(loginId: String): Boolean {
        var isLoginIdOK = false
        //帳號至少6碼，第1碼為英文
        if (loginId.length >= 6) {
            if (loginId.uppercase().first() in 'A'..'Z') {
                isLoginIdOK = true
            }
        }
        return isLoginIdOK
    }

}
