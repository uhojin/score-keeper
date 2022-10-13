package sheridan.youho.assignment2.data

import sheridan.youho.assignment2.model.ScoreData
import kotlinx.coroutines.flow.Flow

interface ScoreDataRepository {

    fun getScoreDataListFlow(): Flow<List<ScoreData>>

    suspend fun getScoreDataById(id: Int): ScoreData

    suspend fun insertScoreData(scoreData: ScoreData)

    // Add new functions here
}