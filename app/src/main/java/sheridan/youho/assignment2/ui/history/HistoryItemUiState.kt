package sheridan.youho.assignment2.ui.history

import java.util.Date

data class HistoryItemUiState(
    val id: Int,
    val date:Date,
    val scoreTeamA: Int,
    val scoreTeamB: Int,
    val addedScore: Int
)