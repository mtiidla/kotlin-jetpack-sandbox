package ee.mtiidla.jetpacksandbox.codelab.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
        @PrimaryKey @ColumnInfo(name = "word") val word: String,
        @ColumnInfo(name = "letter_count") val letterCount: Int) {

    @Ignore
    constructor(word: String) : this(word, word.length)
}
