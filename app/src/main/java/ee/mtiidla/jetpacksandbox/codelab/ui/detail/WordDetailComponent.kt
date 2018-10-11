package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import dagger.Subcomponent

@Subcomponent(
        modules = arrayOf(WordDetailModule::class)
)
interface WordDetailComponent {

    fun inject(fragment: WordDetailFragment)

}