package sheridan.youho.assignment2.model

class ScoreKeeper {
    private var addedScore: Int = 0
    private var scoredTeam: Boolean = true

    fun addScore(
        addedScore: Int,
        scoredTeam: Boolean
    ): ScoreData {
        this.addedScore = addedScore
        this.scoredTeam = scoredTeam
        return getScoreData()
    }

    private fun getScoreData(): ScoreData {
        return ScoreData(
            scoredTeam = scoredTeam,
            addedScore = addedScore
        )
    }
}