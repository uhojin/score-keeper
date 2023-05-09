package sheridan.youho.assignment2.ui.scorekeeper

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import sheridan.youho.assignment2.MainViewModel
import sheridan.youho.assignment2.NavGraphDirections
import sheridan.youho.assignment2.R
import sheridan.youho.assignment2.databinding.FragmentScoreKeeperBinding

@AndroidEntryPoint
class ScoreKeeperFragment : Fragment(), MenuProvider {
    private var _binding: FragmentScoreKeeperBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ScoreKeeperViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentScoreKeeperBinding.inflate(inflater, container, false)

        // Setup fragment menu
        requireActivity().addMenuProvider(
            this, viewLifecycleOwner, Lifecycle.State.RESUMED
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        // A Team Score Buttons
        binding.scoreAAdd1.setOnClickListener {
            // grab team a,b score from screen and give it to the function
            val aTeamScore = binding.scoreA.text.toString().toInt()
            val bTeamScore = binding.scoreB.text.toString().toInt()
            viewModel.addScore(0, 1, aTeamScore,bTeamScore)
            mainViewModel.saveScoreData(viewModel.scoreData)
        }
        binding.scoreAAdd2.setOnClickListener {
            val aTeamScore = binding.scoreA.text.toString().toInt()
            val bTeamScore = binding.scoreB.text.toString().toInt()
            viewModel.addScore(0, 2, aTeamScore,bTeamScore)
            mainViewModel.saveScoreData(viewModel.scoreData)
        }
        // B Team Score Buttons
        binding.scoreBAdd1.setOnClickListener {
            val aTeamScore = binding.scoreA.text.toString().toInt()
            val bTeamScore = binding.scoreB.text.toString().toInt()
            viewModel.addScore(1, 1,aTeamScore,bTeamScore)
            mainViewModel.saveScoreData(viewModel.scoreData)
        }
        binding.scoreBAdd2.setOnClickListener {
            val aTeamScore = binding.scoreA.text.toString().toInt()
            val bTeamScore = binding.scoreB.text.toString().toInt()
            viewModel.addScore(1, 2,aTeamScore,bTeamScore)
            mainViewModel.saveScoreData(viewModel.scoreData)
        }

        binding.resetButton.setOnClickListener {
            // Add reset logic
            viewModel.resetScore()
            mainViewModel.saveScoreData(viewModel.scoreData)
            mainViewModel.clearAllHistory()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_score_keeper, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.action_history -> {
                findNavController().navigate(NavGraphDirections.actionGlobalHistoryFragment())
                true
            }
            else -> false
        }
    }

}