package com.example.liftingtracker.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.liftingtracker.R
import com.example.liftingtracker.databinding.NextButtonFooterBinding
import com.example.liftingtracker.databinding.WorkoutDayItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.ClassCastException


private const val ITEM_VIEW_TYPE_FOOTER = 0
private const val ITEM_VIEW_TYPE_ITEM = 1

class CreateScheduleAdapter(private val onItemClicked: (CreateScheduleItem) -> Unit) :
    ListAdapter<AllItems, RecyclerView.ViewHolder>(DiffCallback()) {

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    private var listSize = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder  {

        return when(viewType){
            ITEM_VIEW_TYPE_FOOTER ->{
                val binding = NextButtonFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                NextButtonFooterViewHolder(binding)

            }
            ITEM_VIEW_TYPE_ITEM -> {
                val binding = WorkoutDayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CreateScheduleItemViewHolder(binding,parent.context)
            }
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)){
            is AllItems.Footer -> ITEM_VIEW_TYPE_FOOTER
            is AllItems.Schedule -> ITEM_VIEW_TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is CreateScheduleItemViewHolder -> {
                val currentItem = getItem(position) as AllItems.Schedule
                holder.bind(currentItem.scheduleItem, onItemClicked)
            }
            is NextButtonFooterViewHolder -> {
                holder.bind(listSize)
            }
        }
    }

    class CreateScheduleItemViewHolder(
        private val binding: WorkoutDayItemBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CreateScheduleItem, onItemClicked: (CreateScheduleItem) -> Unit) {
            //Setting the on click listener
            itemView.setOnClickListener { onItemClicked(item) }
            binding.apply {
                //do work here
                dayNumberText.text = context.getString(R.string.day_num_text, item.dayNum)
            }
        }
    }

    class NextButtonFooterViewHolder(private val binding: NextButtonFooterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(size: Int){
            binding.apply {
               nextButton.visibility = if(size == 0){
                    View.INVISIBLE
                } else {
                    View.VISIBLE
                }
            }
        }
    }

    //For more efficient Recycler View
    class DiffCallback : DiffUtil.ItemCallback<AllItems>() {
        override fun areItemsTheSame(oldItem: AllItems, newItem: AllItems) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: AllItems, newItem: AllItems) =
            oldItem == newItem
    }

    fun addFooterAndSubmitList(list: List<CreateScheduleItem>, footer: FooterItem){
        adapterScope.launch {
            val items = when(list){
                emptyList<CreateScheduleItem>() -> listOf()
                else -> list.map { AllItems.Schedule(it) } + listOf(AllItems.Footer(footer))
            }
            withContext(Dispatchers.Main){
                listSize = items.size
                submitList(items)
            }
        }
    }

}

sealed class AllItems{
    data class Schedule(val scheduleItem: CreateScheduleItem): AllItems(){
        override val id: Int = scheduleItem.dayNum
    }
    data class Footer(val footerItem: FooterItem): AllItems(){
        override val id: Int = footerItem.id
    }

    abstract val id: Int
}