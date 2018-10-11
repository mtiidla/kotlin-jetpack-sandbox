package ee.mtiidla.jetpacksandbox.codelab.ui

import dagger.Subcomponent
import ee.mtiidla.jetpacksandbox.codelab.ui.create.NewWordFragment
import ee.mtiidla.jetpacksandbox.codelab.ui.list.WordListFragment

@Subcomponent
interface FragmentComponent {

    fun inject(fragment: NewWordFragment)

    fun inject(fragment: WordListFragment)

}