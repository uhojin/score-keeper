package sheridan.youho.assignment2.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDataDao {
    @Query("SELECT * FROM score_data")
    fun getAllScoreDataEntitiesFlow(): Flow<List<ScoreDataEntity>>

    @Query("SELECT * FROM score_data WHERE id = :id")
    suspend fun getScoreDataEntityById(id: Int): ScoreDataEntity

    @Insert
    suspend fun insertScoreDataEntity(scoreDataEntity: ScoreDataEntity)

    @Update
    suspend fun updateScoreDataEntity(scoreDataEntity: ScoreDataEntity)

    @Delete
    suspend fun deleteScoreDataEntity(scoreDataEntity: ScoreDataEntity)

    @Query("DELETE FROM score_data WHERE id = :id")
    suspend fun deleteScoreDataEntityById(id: Int)

    @Query("DELETE FROM score_data")
    suspend fun deleteAllScoreDataEntities()
}