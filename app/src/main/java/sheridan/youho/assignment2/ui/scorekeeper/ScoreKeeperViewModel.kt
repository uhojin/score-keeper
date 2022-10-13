package sheridan.youho.assignment2.ui.scorekeeper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sheridan.youho.assignment2.model.ScoreData
import sheridan.youho.assignment2.model.ScoreKeeper

class ScoreKeeperViewModel() : ViewModel() {
    val scoreKeeper = ScoreKeeper()
    // LiveData
    private val _liveUiState = MutableLiveData(ScoreKeeperUiState())
    val liveUiState: LiveData<ScoreKeeperUiState> = _liveUiState

    private var _scoreData: ScoreData? = null
    val scoreData: ScoreData
        get() = _scoreData!!

    fun addScore(
        team: Int,
        gainedScore: Int
    ) {
        val scoreData = scoreKeeper.addScore(gainedScore, team)
        val uiState = _liveUiState.value
        //_liveUiState.value = uiState?.copy(
        //    addScore = scoreData.addedScore,
        //    scoredTeam = scoreData.scoredTeam
        //)
        _scoreData = scoreData
    }
}