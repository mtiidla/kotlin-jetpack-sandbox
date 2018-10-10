package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import dagger.Module
import dagger.Provides


@Module
abstract class WordDetailModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideArgs(fragment: WordDetailFragment) : WordDetailScreenArg = fragment.arguments?.getParcelable("arg") as WordDetailScreenArg

    }

}