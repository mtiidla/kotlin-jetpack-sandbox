package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import ee.mtiidla.jetpacksandbox.codelab.data.Word
import ee.mtiidla.jetpacksandbox.codelab.data.WordRepository
import javax.inject.Inject


class WordDetailViewModel @Inject constructor(private val repository: WordRepository, argument: WordDetailScreenArg) : ViewModel() {

    val wordDetail : LiveData<Word> = repository.word(argument.word)

    fun onDeleteWordClicked() {
        wordDetail.value?.let {
            repository.deleteWord(it.word)
        }
    }

}