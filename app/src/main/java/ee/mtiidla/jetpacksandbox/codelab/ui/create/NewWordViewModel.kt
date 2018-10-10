package ee.mtiidla.jetpacksandbox.codelab.ui.create

import android.arch.lifecycle.ViewModel
import ee.mtiidla.jetpacksandbox.codelab.data.Word
import ee.mtiidla.jetpacksandbox.codelab.data.WordRepository
import javax.inject.Inject


class NewWordViewModel @Inject constructor(private val repository: WordRepository) : ViewModel() {

    fun onAddWordClicked(word: String) {
        repository.insert(Word(word))
    }

}