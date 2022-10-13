package sheridan.youho.assignment2.model
import java.util.Date

data class ScoreData(
    val id: Int = 0,
    val scoreTeamA: Int,
    val scoreTeamB: Int,
    val addedScore: Int,
    val date: Date = Date()
)
