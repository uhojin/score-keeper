package sheridan.youho.assignment2.ui.about

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AboutFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder
            .setTitle("Kabaddi Kounter")
            .setMessage("Hojin You, Sheridan College, 2022")
            .setPositiveButton(android.R.string.ok, null)
        return builder.create()
    }
}