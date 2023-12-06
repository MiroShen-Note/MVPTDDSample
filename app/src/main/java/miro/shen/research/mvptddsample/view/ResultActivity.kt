package miro.shen.research.mvptddsample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import miro.shen.research.mvptddsample.R

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val id = intent.getStringExtra("ID")

    }
}
