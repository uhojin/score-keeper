package sheridan.youho.assignment2.model

class ScoreKeeper {
    private var addedScore: Int = 0
    private var scoredTeam: Int = 0
    private var scoreTeamA: Int = 0
    private var scoreTeamB: Int = 0


    fun resetScore(): ScoreData {
        return resetScoreData()
    }

    private fun resetScoreData(): ScoreData {
        return ScoreData(
            scoredTeam = 0,
            addedScore = 0,
            scoreTeamA = 0,
            scoreTeamB = 0
        )
    }

    fun addScore(
        addedScore: Int,
        scoredTeam: Int,
        scoreTeamA: Int,
        scoreTeamB: Int
    ): ScoreData {
        this.addedScore = addedScore
        this.scoredTeam = scoredTeam
        this.scoreTeamA = scoreTeamA
        this.scoreTeamB = scoreTeamB
        return getScoreData()
    }

    private fun getScoreData(): ScoreData {
       /* return ScoreData(
            scoredTeam = scoredTeam,
            addedScore = addedScore,

        )*/
        // check for how much score first, then figure out the team that score
        // nvm do it the other way

        // Team A == 0
        // Team B == 1
        if (scoredTeam == 0) {
            if (addedScore == 1) {
                return ScoreData(
                    // Team A got 1 point
                    scoredTeam = scoredTeam,
                    addedScore = addedScore,
                    scoreTeamA = scoreTeamA + 1,
                    scoreTeamB = scoreTeamB
                )
            } else {
                return ScoreData(
                    // Team A got 2 points
                    scoredTeam = scoredTeam,
                    addedScore = addedScore,
                    scoreTeamA = scoreTeamA + 2,
                    scoreTeamB = scoreTeamB
                )
            }
        } else {
            if (addedScore == 1) {
                return ScoreData(
                    // Team B got 1 point
                    scoredTeam = scoredTeam,
                    addedScore = addedScore,
                    scoreTeamA = scoreTeamA,
                    scoreTeamB = scoreTeamB + 1
                )
            } else {
                return ScoreData(
                    // Team B got 2 points
                    scoredTeam = scoredTeam,
                    addedScore = addedScore,
                    scoreTeamA = scoreTeamA,
                    scoreTeamB = scoreTeamB + 2
                )
            }
        }
    }
}