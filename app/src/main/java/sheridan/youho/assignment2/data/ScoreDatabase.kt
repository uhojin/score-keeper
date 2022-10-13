package sheridan.youho.assignment2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ScoreDataEntity::class], version = 1, exportSchema = false)
@TypeConverters(DataConverters::class)
abstract class ScoreDatabase : RoomDatabase() {
    abstract fun scoreDataDao(): ScoreDataDao
}