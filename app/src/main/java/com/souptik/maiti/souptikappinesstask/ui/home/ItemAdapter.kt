package com.souptik.maiti.souptikappinesstask.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.souptik.maiti.souptikappinesstask.R
import com.souptik.maiti.souptikappinesstask.data.remote.response.ItemResponse
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemAdapter(val itemList: ArrayList<ItemResponse> ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(), Filterable {
    private var itemListFull  = ArrayList<ItemResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemResponse: ItemResponse){
            itemView.tv_title.text = itemResponse.title
            itemView.tv_by.text = itemResponse.by
            itemView.tv_country.text = itemResponse.country
            itemView.tv_state.text = itemResponse.state
        }
    }

    fun appendData(dataList: List<ItemResponse>){
        this.itemList.addAll(dataList)
        this.itemListFull.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return exampleFilter
    }

    private val exampleFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filteredList: MutableList<ItemResponse> = ArrayList()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(itemListFull)
            } else {
                val filterPattern =
                    constraint.toString().toLowerCase().trim()
                for (item in itemListFull) {
                    if (item.title.toLowerCase().startsWith(filterPattern)) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(
            constraint: CharSequence,
            results: FilterResults
        ) {
            itemList.clear()
            itemList.addAll(results.values as List<ItemResponse>)
            notifyDataSetChanged()
        }
    }
}