package ee.mtiidla.jetpacksandbox

import android.arch.core.executor.testing.InstantTaskExecutorRule
import ee.mtiidla.jetpacksandbox.codelab.data.WordRepository
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.mockito.Mockito.mock

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

    }

    /**
     * a kotlin friendly mock that handles generics
     */
    inline fun <reified T> mock(): T = Mockito.mock(T::class.java)

}
