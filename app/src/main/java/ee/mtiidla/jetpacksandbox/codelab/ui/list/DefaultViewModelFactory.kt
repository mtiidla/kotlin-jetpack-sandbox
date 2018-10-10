package ee.mtiidla.jetpacksandbox.codelab.ui.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import ee.mtiidla.jetpacksandbox.codelab.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope
class DefaultViewModelFactory<VM : ViewModel> @Inject constructor(private val viewModelProvider: Provider<VM>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = viewModelProvider.get()
        if (viewModel.javaClass.isAssignableFrom(modelClass)) {
            return viewModel as T
        } else {
            throw IllegalArgumentException("ViewModel ${viewModel::class.java.name} is not assignable from requested model class ${modelClass.name}")
        }
    }
}
