package com.example.liftingtracker.feature_create_schedule.presentation

import android.os.Bundle
import android.view.*
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.liftingtracker.core.presentation.MainActivity
import com.example.liftingtracker.databinding.FragmentGetStartedBinding



/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class GetStartedFragment : Fragment() {


    private lateinit var binding: FragmentGetStartedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGetStartedBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).supportActionBar?.hide()
        hideSystemBars()

        binding.getStartedButton.setOnClickListener {
            findNavController().navigate(GetStartedFragmentDirections.actionGetStartedFragmentToCreateSchedule())
        }
    }

    private fun hideSystemBars() {
        val window = requireActivity().window
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(
                window.decorView
            ) ?: return
        // Configure the behavior of the hidden system bars
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}
