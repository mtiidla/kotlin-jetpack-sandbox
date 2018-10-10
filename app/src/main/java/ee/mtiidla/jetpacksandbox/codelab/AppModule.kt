package ee.mtiidla.jetpacksandbox.codelab

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import ee.mtiidla.jetpacksandbox.codelab.data.WordRoomDatabase
import ee.mtiidla.jetpacksandbox.codelab.data.migrations.all

@Module
class AppModule(private val application: Application) {

    @Provides
    @ApplicationScope
    fun providesApplication(): Application = application

    @Module
    companion object {

        @JvmStatic
        @Provides
        @ApplicationScope
        fun provideDatabase(application: Application): WordRoomDatabase =
                Room.databaseBuilder(application,
                        WordRoomDatabase::class.java, "word_database")
                        .addMigrations(*all().toTypedArray())
                        .build()

        @JvmStatic
        @Provides
        @ApplicationScope
        fun provideWordDao(database: WordRoomDatabase) = database.wordDao()

    }

}
