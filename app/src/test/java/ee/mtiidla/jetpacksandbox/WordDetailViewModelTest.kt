package ee.mtiidla.jetpacksandbox

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import ee.mtiidla.jetpacksandbox.codelab.data.Word
import ee.mtiidla.jetpacksandbox.codelab.data.WordRepository
import ee.mtiidla.jetpacksandbox.codelab.ui.detail.WordDetailScreenArg
import ee.mtiidla.jetpacksandbox.codelab.ui.detail.WordDetailViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnit4::class)
class WordDetailViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val repository = mock(WordRepository::class.java)

    @Test
    fun testObserveWord() {

        val expected = Word("hello")
        val wordId = expected.word

        val liveData = MutableLiveData<Word>()
        liveData.value = expected

        `when`(repository.word(wordId)).thenReturn(liveData)

        val viewModel = WordDetailViewModel(repository, WordDetailScreenArg(wordId))

        val observer = mock<Observer<Word>>()

        viewModel.wordDetail.observeForever(observer)

        verify(repository).word(wordId)
        verify(observer).onChanged(expected)


    }

    /**
     * a kotlin friendly mock that handles generics
     */
    inline fun <reified T> mock(): T = mock(T::class.java)

}
