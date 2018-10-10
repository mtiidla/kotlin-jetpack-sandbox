package ee.mtiidla.jetpacksandbox.codelab

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ee.mtiidla.jetpacksandbox.codelab.ui.create.NewWordFragment
import ee.mtiidla.jetpacksandbox.codelab.ui.detail.WordDetailFragment
import ee.mtiidla.jetpacksandbox.codelab.ui.detail.WordDetailModule
import ee.mtiidla.jetpacksandbox.codelab.ui.list.WordListFragment

@Module
abstract class CodelabFragmentsModule {

    /**
     * This solution requires to define all injectable fragments here. To use parameters from the
     * these fragments, another module class has to be created that will be able to provide them.
     *
     * The Android Dagger library will generate a subcomponent for each activity/fragment that is
     * provided via @ContributesAndroidInjector, thus manual creation of modules and subcomponents
     * is not necessary.
     *
     * There may be some kotlin magic that would simplify creating the extra module class, but I am
     * not aware of that right now.
     *
     * Note that with multiple activities, each activity that hosts injectable fragments need to
     * define such module like this one and implement HasSupportFragmentInjector
     *
     * Check out this huge blog post regarding the setup https://proandroiddev.com/how-to-android-dagger-2-10-2-11-butterknife-mvp-part-1-eb0f6b970fd
     */

    @ContributesAndroidInjector(modules = [WordDetailModule::class])
    abstract fun contributesWordDetailFragment(): WordDetailFragment

    @ContributesAndroidInjector
    abstract fun contributesWordListFragment(): WordListFragment

    @ContributesAndroidInjector
    abstract fun contributesNewWordFragment(): NewWordFragment

}
