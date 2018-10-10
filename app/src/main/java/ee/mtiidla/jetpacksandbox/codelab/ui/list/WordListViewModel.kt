package ee.mtiidla.jetpacksandbox.codelab.ui.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ee.mtiidla.jetpacksandbox.codelab.data.Word
import ee.mtiidla.jetpacksandbox.codelab.data.WordRepository
import javax.inject.Inject

class WordListViewModel @Inject constructor(repository: WordRepository) : ViewModel() {

    val allWords: LiveData<List<Word>> = repository.allWords()

}
