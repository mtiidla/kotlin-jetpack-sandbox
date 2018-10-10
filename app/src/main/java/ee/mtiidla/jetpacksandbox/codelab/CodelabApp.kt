package ee.mtiidla.jetpacksandbox.codelab

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class CodelabApp : DaggerApplication() {

    override fun onCreate() {
        Injection.init(this)
        applyAutoInjector()
        super.onCreate()


    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return Injection.appComponent
    }
}
