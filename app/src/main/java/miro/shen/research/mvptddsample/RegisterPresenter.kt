package miro.shen.research.mvptddsample

class RegisterPresenter(val view: RegisterContract.IRegisterView) : RegisterContract.IRegisterPresenter {
    override fun register(loginId: String, password: String) {

        var isPwdOK = false
        if(password.length >= 8){
            if(password.uppercase().first() in 'A'..'Z'){
                if(password.findAnyOf((0..9).map { it.toString() }) != null){
                    isPwdOK = true
                }
            }
        }

        if (!loginVerify(loginId)) {
            view.onInputDataError("錯誤", "帳號至少要6碼，第1碼為英文")
        } else if(!isPwdOK) {
            view.onInputDataError("錯誤", "密碼至少要8碼，第1碼為英文，並包含1碼數字")
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
