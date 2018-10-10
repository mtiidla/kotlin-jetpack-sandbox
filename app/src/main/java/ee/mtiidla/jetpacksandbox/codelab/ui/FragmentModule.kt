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

        // To provide parameters to ViewModels per VM, a component and module is required for each
        // fragment, however that approach would require a lot of boilerplate to write the components
        // and modules. A solution would be piggyback on top of fragment arguments, so keep a single
        // FragmentModule and FragmentComponent but expose its arguments for resolving VM parameters

        // Ofc this module becomes a god object and a confusing mess
        // Here could be a list of all the parameters for all the fragments cast to the correct type

        @JvmStatic
        @Provides
        fun provideWordDetailScreenArgument(argument: Any) : WordDetailScreenArg = argument as WordDetailScreenArg

    }

}