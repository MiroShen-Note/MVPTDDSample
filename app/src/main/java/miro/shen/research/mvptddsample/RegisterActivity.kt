package miro.shen.research.mvptddsample

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import miro.shen.research.mvptddsample.databinding.ActivityRegisterBinding

//import kotlinx.android.synthetic.main.activity_register.send

class RegisterActivity : AppCompatActivity(), RegisterContract.IRegisterView {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.send.setOnClickListener {
            val loginId = binding.loginId.text.toString()
            val pwd = binding.password.text.toString()

            val registerPresenter = RegisterPresenter(this)
            registerPresenter
                .register(loginId, pwd)
        }

    }

    override fun onInputDataError(title: String, message: String) {
        val builder = AlertDialog.Builder(this)

        builder.setMessage(message)
            .setTitle(title)

        builder.show()
    }
}
