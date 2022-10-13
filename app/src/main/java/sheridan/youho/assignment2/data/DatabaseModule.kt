package sheridan.youho.assignment2.data

import android.content.Context
import android.util.Log
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideScoreDataDao(database: ScoreDatabase): ScoreDataDao {
        Log.d("DependencyInjection", "Providing ScoreDataDao")
        return database.scoreDataDao()
    }

    @Singleton
    @Provides
    fun provideScoreDatabase(@ApplicationContext context: Context): ScoreDatabase {
        Log.d("DependencyInjection", "Providing ScoreDatabase")
        return Room.databaseBuilder(
            context.applicationContext,
            ScoreDatabase::class.java,
            "score_database"
        ).build()
    }
}