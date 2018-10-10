package ee.mtiidla.jetpacksandbox.codelab.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Word::class], version = 2)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

}
