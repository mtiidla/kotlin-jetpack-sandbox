package ee.mtiidla.jetpacksandbox.codelab.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import ee.mtiidla.jetpacksandbox.codelab.ui.detail.WordDetailScreenArg

@Module
abstract class FragmentModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideArguments(fragment: Fragment) : Bundle = fragment.arguments ?: Bundle.EMPTY

        @JvmStatic
        @Provides
        fun provideArgument(bundle: Bundle) : Any = bundle.getParcelable("arg")!!

        @JvmStatic
        @Provides
        fun provideWordDetailScreenArgument(argument: Any) : WordDetailScreenArg = argument as WordDetailScreenArg

    }

}