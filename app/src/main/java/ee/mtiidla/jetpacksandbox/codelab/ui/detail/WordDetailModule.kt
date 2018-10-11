package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides

@Module
class WordDetailModule(private val fragment: Fragment) {

    /**
     * This solution is most straight-forward and manual. Every VM that requires arguments from fragments
     * also requires creating a SubComponent and a Module.
     *
     * Fragments without parameters can be injected directly at the app level. Thus those fragments
     * could use the same singleton ViewModelFactory, so it would be more accurate to create a VM
     * factory for global VMs and a instance based VM where new instance is injected into every fragment
     * that does require parameters (thus can't be on application scope)
     */

    @Provides
    fun provideFragment() = fragment;

    @Provides
    fun provideArguments(fragment: Fragment): Bundle = fragment.arguments ?: Bundle.EMPTY

    @Provides
    fun provideArgument(bundle: Bundle): Any = bundle.getParcelable("arg")!!

    @Provides
    fun provideWordDetailScreenArgument(argument: Any): WordDetailScreenArg = argument as WordDetailScreenArg

}