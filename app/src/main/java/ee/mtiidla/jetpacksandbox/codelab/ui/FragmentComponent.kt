package ee.mtiidla.jetpacksandbox.codelab.ui

import android.support.v4.app.Fragment
import dagger.BindsInstance
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

        @BindsInstance
        fun fragment(fragment: Fragment) : Builder

        fun build() : FragmentComponent
    }

}