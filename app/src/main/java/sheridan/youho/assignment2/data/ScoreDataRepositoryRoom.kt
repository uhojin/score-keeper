package sheridan.youho.assignment2.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import sheridan.youho.assignment2.model.ScoreData
import javax.inject.Inject

class ScoreDataRepositoryRoom @Inject constructor(
    private val scoreDataDao: ScoreDataDao
) : ScoreDataRepository {

    override fun getScoreDataListFlow(): Flow<List<ScoreData>> {
        return scoreDataDao.getAllScoreDataEntitiesFlow().map { entityList ->
            entityList.map { entity -> entity.toScoreData() }
        }
    }

    override suspend fun insertScoreData(scoreData: ScoreData) {
        scoreDataDao.insertScoreDataEntity(scoreData.toScoreDataEntity())
    }

    override suspend fun deleteScoreDataById(id: Int) {
        scoreDataDao.deleteScoreDataEntityById(id)
    }

    override suspend fun getScoreDataById(id: Int) =
        scoreDataDao.getScoreDataEntityById(id).toScoreData()

    override suspend fun deleteAllScoreData() {
        scoreDataDao.deleteAllScoreDataEntities()
    }
}

fun ScoreData.toScoreDataEntity() = ScoreDataEntity(
    id, scoreTeamA, scoreTeamB, addedScore, scoredTeam, date
)

fun ScoreDataEntity.toScoreData() = ScoreData(
    id, scoreTeamA, scoreTeamB, addedScore, scoredTeam, date
)