package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import android.arch.lifecycle.ViewModel
import ee.mtiidla.jetpacksandbox.codelab.data.WordRepository
import javax.inject.Inject


class WordDetailViewModel @Inject constructor(private val repository: WordRepository) : ViewModel() {

    var argument: WordDetailScreenArg? = null
        set(value) {
            if (field == null) {
                field = value
            }
        }


    fun wordDetail() = repository.word(argument!!.word)

    fun onDeleteWordClicked() {
        repository.deleteWord(argument!!.word)
    }

}