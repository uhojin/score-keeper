package sheridan.youho.assignment2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sheridan.youho.assignment2.data.ScoreDataRepository
import sheridan.youho.assignment2.model.ScoreData
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ScoreDataRepository
) : ViewModel() {
    fun saveScoreData(scoreData: ScoreData) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertScoreData(scoreData)
        }
    fun clearAllHistory() =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllScoreData()
        }

    init {
        Log.d("DependencyInjection", "Created MainViewModel")
    }
}