package ee.mtiidla.jetpacksandbox.codelab.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ee.mtiidla.jetpacksandbox.R
import ee.mtiidla.jetpacksandbox.codelab.ui.list.WordListFragment

class CodelabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codelab)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, WordListFragment.newInstance())
                    .commit();
        }

    }

}
