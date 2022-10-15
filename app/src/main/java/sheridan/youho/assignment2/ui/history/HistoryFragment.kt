package sheridan.youho.assignment2.ui.history

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import sheridan.youho.assignment2.MainViewModel
import sheridan.youho.assignment2.R
import sheridan.youho.assignment2.databinding.FragmentHistoryBinding

@AndroidEntryPoint
class HistoryFragment : Fragment(), MenuProvider {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HistoryViewModel by viewModels()
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        // Setup fragment view
        requireActivity().addMenuProvider(
            this, viewLifecycleOwner, Lifecycle.State.RESUMED
        )
        val adapter = HistoryListAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.liveItemUiStateList.observe(viewLifecycleOwner){ uiItemStateList ->
            if (uiItemStateList.isNotEmpty()){
                adapter.submitList(uiItemStateList)
                binding.recyclerView.visibility = View.VISIBLE
                binding.emptyHistoryMessage.visibility = View.GONE
            } else {
                binding.recyclerView.visibility = View.GONE
                binding.emptyHistoryMessage.visibility = View.VISIBLE
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_history, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.action_clear_all_history -> {
                mainViewModel.clearAllHistory()
                true
            }
            else -> false
        }
    }
}