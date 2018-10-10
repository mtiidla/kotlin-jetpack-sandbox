package ee.mtiidla.jetpacksandbox.codelab.data.migrations

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration


class MIGRATE_1_2 : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE word_table ADD COLUMN letter_count INTEGER NOT NULL default 0;")
    }
}

fun all(): List<Migration> {
    return listOf(MIGRATE_1_2())
}