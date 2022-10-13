package sheridan.youho.assignment2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "score_data")
class ScoreDataEntity(

    @PrimaryKey(autoGenerate = true)
    // Default column name
    val id: Int = 0,

    @ColumnInfo(name = "team_a_score")
    val scoreTeamA: Int,

    @ColumnInfo(name = "team_b_score")
    val scoreTeamB: Int,

    @ColumnInfo(name = "score_gained")
    val addedScore: Int,

    @ColumnInfo(name = "scored_team")
    val scoredTeam: Int,
    // Default column name
    val date: Date
)