package ee.mtiidla.jetpacksandbox.codelab

import android.app.Application

class CodelabApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Injection.init(this)

    }
}
