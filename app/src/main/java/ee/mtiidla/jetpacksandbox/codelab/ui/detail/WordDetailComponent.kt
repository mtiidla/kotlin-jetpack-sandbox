package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import dagger.Subcomponent

@Subcomponent
interface WordDetailComponent {

    /**
     * This solution removes the need for creating a module for every single fragment that requires
     * parameters, but still requires creating a component for every fragment. It provides type
     * safety for the parameters as each component can extract specific fragment arguments to forward
     * them to the VMs.
     *
     * While it allows decoupling, it can't be used to inject fragments in a generic and global way
     * e.g. using global fragment lifecycle callbacks.
     */

    fun inject(fragment: WordDetailFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): WordDetailComponent
    }

}