package sheridan.youho.assignment2.ui.scorekeeper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import sheridan.youho.assignment2.MainViewModel
import sheridan.youho.assignment2.databinding.FragmentScoreKeeperBinding

@AndroidEntryPoint
class ScoreKeeperFragment : Fragment(), MenuProvider {
    private var _binding: FragmentScoreKeeperBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return binding.root
    }
}