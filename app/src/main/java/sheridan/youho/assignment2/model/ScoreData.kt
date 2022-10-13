package sheridan.youho.assignment2.model
import java.util.Date

data class ScoreData(
    val id: Int = 0,
    val scoreTeamA: Int = 0,
    val scoreTeamB: Int = 0,
    val addedScore: Int,
    val scoredTeam: Int,
    val date: Date = Date()
)
