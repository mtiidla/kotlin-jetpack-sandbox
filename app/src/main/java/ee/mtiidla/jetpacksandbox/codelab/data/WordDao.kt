package ee.mtiidla.jetpacksandbox.codelab.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun selectAll(): LiveData<List<Word>>

    @Query("SELECT * FROM word_table WHERE word = :wordId LIMIT 1")
    fun selectById(wordId: String): LiveData<Word>

    @Query("DELETE FROM word_table WHERE word = :wordId")
    fun delete(wordId: String)

}
