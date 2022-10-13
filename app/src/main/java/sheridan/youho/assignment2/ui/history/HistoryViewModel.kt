package sheridan.youho.assignment2.ui.history

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import sheridan.youho.assignment2.data.ScoreDataRepository
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: ScoreDataRepository
) : ViewModel() {
    val liveItemUiStateList: LiveData<List<HistoryItemUiState>> =
        repository.getScoreDataListFlow().map { scoreDataList ->
            scoreDataList.map { scoreData ->
                HistoryItemUiState(
                    id = scoreData.id,
                    date = scoreData.date,
                    scoreTeamA = scoreData.scoreTeamA,
                    scoreTeamB = scoreData.scoreTeamB,
                    addedScore = scoreData.addedScore
                )
            }
        }.flowOn(Dispatchers.IO).asLiveData()

    init {
        Log.d("DependencyInjection","Created HistoryViewModel")
    }
}