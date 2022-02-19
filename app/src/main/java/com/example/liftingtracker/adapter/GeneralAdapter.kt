package com.example.liftingtracker.adapter

//data class Nothing(
//    val id: Int
//)
//
//class ChampionListAdapterNoHeader(private val onItemClicked: (Nothing) -> Unit) :
//    ListAdapter<Nothing, ChampionListAdapterNoHeader.NothingItemViewHolder>(DiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NothingItemViewHolder {
//
//        val binding = NothingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return NothingItemViewHolder(binding, parent.context)
//    }
//
//
//    override fun onBindViewHolder(holder: NothingItemViewHolder, position: Int) {
//        val currentItem = getItem(position)
//        holder.bind(currentItem, onItemClicked)
//    }
//
//    class NothingItemViewHolder(
//        private val binding: NothingBinding,
//        private val context: Context
//    ) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(example: Nothing, onItemClicked: (Nothing) -> Unit) {
//            //Setting the on click listener
//            itemView.setOnClickListener { onItemClicked(example) }
//            binding.apply {
//                //do work here
//            }
//        }
//    }
//
//    //For more efficient Recycler View
//    class DiffCallback : DiffUtil.ItemCallback<Nothing>() {
//        override fun areItemsTheSame(oldItem: Nothing, newItem: Nothing) =
//            oldItem.id == newItem.id
//
//        override fun areContentsTheSame(oldItem: Nothing, newItem: Nothing) =
//            oldItem == newItem
//    }
//
//}