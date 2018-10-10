package ee.mtiidla.jetpacksandbox.codelab

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ee.mtiidla.jetpacksandbox.R
import ee.mtiidla.jetpacksandbox.codelab.ui.CodelabActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, CodelabActivity::class.java))

        finish()
    }
}
