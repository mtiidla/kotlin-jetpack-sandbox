package ee.mtiidla.jetpacksandbox.codelab.ui

import dagger.Module

@Module
abstract class FragmentModule {

    /**
     * With this solution, ViewModels do not have any scope. Thus VMFactory is ApplicationScope
     *
     * Thus the factory is only created once, but on the other hand cannot pass parameters to VMs
     *
     * The drawback is that the parameters to VMs have to be passed manually via setters
     * This is better explained from in this BlogPost https://proandroiddev.com/viewmodel-with-dagger2-architecture-components-2e06f06c9455
     * And github issue https://github.com/googlesamples/android-architecture-components/issues/207
     * And example https://github.com/googlesamples/android-architecture-components/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/ui/user/UserViewModel.kt
     */


}