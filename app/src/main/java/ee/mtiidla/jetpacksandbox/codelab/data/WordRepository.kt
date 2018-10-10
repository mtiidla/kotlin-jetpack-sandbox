package ee.mtiidla.jetpacksandbox.codelab.data

import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import ee.mtiidla.jetpacksandbox.codelab.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class WordRepository @Inject constructor(private val wordDao: WordDao) {

    fun insert(word: Word) {
        SimpleAsyncTask { wordDao.insert(word) }.execute()
    }

    fun allWords() : LiveData<List<Word>> = wordDao.selectAll()

    fun word(wordId: String) : LiveData<Word> = wordDao.selectById(wordId)

    fun deleteWord(wordId: String) {
        SimpleAsyncTask { wordDao.delete(wordId) }.execute()
    }

    private class SimpleAsyncTask(val body: () -> Unit) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg words: Void): Void? {
            Thread.sleep(2000)
            body.invoke()
            Thread.sleep(2000)
            return null
        }
    }

}
