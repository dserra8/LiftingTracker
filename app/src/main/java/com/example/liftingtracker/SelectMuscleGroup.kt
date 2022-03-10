package com.example.liftingtracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.liftingtracker.core.data.local.ListOfMuscleGroups
import com.example.liftingtracker.feature_create_schedule.presentation.CreateScheduleViewModel
import com.example.liftingtracker.databinding.FragmentSelectMuscleGroupBinding
import com.google.android.material.chip.Chip


class SelectMuscleGroup : Fragment() {

    private lateinit var binding: FragmentSelectMuscleGroupBinding

    private val args: SelectMuscleGroupArgs by navArgs()

    private val viewModel: CreateScheduleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSelectMuscleGroupBinding.inflate(layoutInflater)

        binding.finishMuscleGroupButton.setOnClickListener {
            val list = binding.muscleChipGroup.children.toList().filter { (it as Chip).isChecked }.map { view -> (view as Chip).text.toString() }
            if(list.isNotEmpty()){
                viewModel.dayMap[args.dayNum] = list
                findNavController().navigate(SelectMuscleGroupDirections.actionSelectMuscleGroupToCreateSchedule())
            }
        }

        binding.muscleGroupTitle.text = getString(R.string.choose_muscle_groups, args.dayNum)

        ListOfMuscleGroups.LIST.forEach { muscle ->
            binding.muscleChipGroup.addView(addChip(muscle))
        }
        return binding.root
    }

    private fun addChip(text: String): Chip {
        val chip = Chip(context)
        chip.text = text
        return chip
    }

}