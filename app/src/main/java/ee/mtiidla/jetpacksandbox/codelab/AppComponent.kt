package ee.mtiidla.jetpacksandbox.codelab

import dagger.Component
import ee.mtiidla.jetpacksandbox.codelab.ui.create.NewWordFragment
import ee.mtiidla.jetpacksandbox.codelab.ui.detail.WordDetailComponent
import ee.mtiidla.jetpacksandbox.codelab.ui.list.WordListFragment

@ApplicationScope
@Component(
        modules = arrayOf(AppModule::class)
)
interface AppComponent {

    fun inject(app: CodelabApp)

    fun inject(fragment: WordListFragment)

    fun inject(fragment: NewWordFragment)

    fun wordDetailBuilder() : WordDetailComponent.Builder

}
