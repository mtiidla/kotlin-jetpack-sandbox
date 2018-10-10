package ee.mtiidla.jetpacksandbox.codelab

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ee.mtiidla.jetpacksandbox.codelab.ui.CodelabActivityModule

@ApplicationScope
@Component(modules = [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    CodelabActivityModule::class
])
interface AppComponent : AndroidInjector<CodelabApp> {

}
