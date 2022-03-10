package com.example.liftingtracker.feature_create_schedule.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.liftingtracker.adapter.CreateScheduleAdapter
import com.example.liftingtracker.adapter.CreateScheduleItem
import com.example.liftingtracker.adapter.FooterItem
import com.example.liftingtracker.databinding.FragmentCreateScheduleBinding


class CreateSchedule : Fragment() {

    private lateinit var binding: FragmentCreateScheduleBinding

    private lateinit var listAdapter: CreateScheduleAdapter

    private val viewModel: CreateScheduleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateScheduleBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter = CreateScheduleAdapter{
            findNavController().navigate(CreateScheduleDirections.actionCreateScheduleToSelectMuscleGroup(it.dayNum))
        }

        binding.apply {

            createScheduleRecyclerView.apply {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(context)
            }

            splitNumSlider.addOnChangeListener { slider, value, fromUser ->
                val list = mutableListOf<CreateScheduleItem>()

                for(i in 1..value.toInt()){
                    list.add(CreateScheduleItem(i))
                }
                listAdapter.addFooterAndSubmitList(list, FooterItem(0))
            }


        }


    }
}