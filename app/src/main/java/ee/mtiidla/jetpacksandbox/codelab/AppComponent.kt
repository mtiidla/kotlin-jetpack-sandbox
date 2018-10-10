package ee.mtiidla.jetpacksandbox.codelab

import dagger.Component
import ee.mtiidla.jetpacksandbox.codelab.ui.FragmentComponent

@ApplicationScope
@Component(
        modules = arrayOf(AppModule::class)
)
interface AppComponent {

    fun inject(app: CodelabApp)

    fun fragmentBuilder() : FragmentComponent.Builder

}
