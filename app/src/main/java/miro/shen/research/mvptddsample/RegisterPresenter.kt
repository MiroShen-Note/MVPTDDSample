package miro.shen.research.mvptddsample

class RegisterPresenter(val view: RegisterContract.IRegisterView) : RegisterContract.IRegisterPresenter {
    override fun register(loginId: String, password: String) {

        if (!loginVerify(loginId)) {
            view.onInputDataError("錯誤", "帳號至少要6碼，第1碼為英文")
        }
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
