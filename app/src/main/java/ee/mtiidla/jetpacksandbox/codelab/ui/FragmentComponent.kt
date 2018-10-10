package ee.mtiidla.jetpacksandbox.codelab.ui

import dagger.Subcomponent
import ee.mtiidla.jetpacksandbox.codelab.ui.create.NewWordFragment
import ee.mtiidla.jetpacksandbox.codelab.ui.detail.WordDetailFragment
import ee.mtiidla.jetpacksandbox.codelab.ui.list.WordListFragment

@Subcomponent(
        modules = arrayOf(FragmentModule::class)
)
interface FragmentComponent {

    fun inject(fragment: WordDetailFragment)

    fun inject(fragment: NewWordFragment)

    fun inject(fragment: WordListFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build() : FragmentComponent
    }

}