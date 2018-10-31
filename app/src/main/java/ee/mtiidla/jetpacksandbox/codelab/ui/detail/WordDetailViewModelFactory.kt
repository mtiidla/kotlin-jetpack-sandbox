package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import ee.mtiidla.jetpacksandbox.codelab.data.WordRepository

class WordDetailViewModelFactory @AssistedInject constructor(
    private val repository: WordRepository,
    @Assisted private val argument: WordDetailScreenArg
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WordDetailViewModel(repository, argument) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(argument: WordDetailScreenArg): WordDetailViewModelFactory
    }
}