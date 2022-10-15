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

    fun resetScore() {
        val scoreData = scoreKeeper.resetScore()
        val uiState = _liveUiState.value
        _liveUiState.value = uiState?.copy(
            scoreA = 0,
            scoreB = 0
        )
        _scoreData = scoreData
    }

    fun addScore(
        team: Int,
        gainedScore: Int,
        aTeamScore: Int,
        bTeamScore: Int
    ) {
        val scoreData = scoreKeeper.addScore(gainedScore, team, aTeamScore, bTeamScore)
        val uiState = _liveUiState.value
//        _liveUiState.value = uiState?.copy(
//            scoreA = scoreData.scoreTeamA,
//            scoreB = scoreData.scoreTeamB
//        )
        if (team == 0) {
            if (gainedScore == 1){
                _liveUiState.value = uiState?.copy(
                    scoreA = aTeamScore + 1,
                    scoreB = bTeamScore
                )
            } else {
                _liveUiState.value = uiState?.copy(
                    scoreA = aTeamScore + 2,
                    scoreB = bTeamScore
                )
            }
        } else {
            if (gainedScore == 1){
                _liveUiState.value = uiState?.copy(
                    scoreA = aTeamScore,
                    scoreB = bTeamScore + 1
                )
            } else {
                _liveUiState.value = uiState?.copy(
                    scoreA = aTeamScore,
                    scoreB = bTeamScore + 2
                )
            }
        }
        _scoreData = scoreData
    }
}