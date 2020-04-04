package se.hackforsweden.foodbox.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_time.view.*
import se.hackforsweden.foodbox.R


class TimeAdapter(
    private val onItemClick: (String) -> Unit
) : ListAdapter<String, TimeAdapter.TimeViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: TimeViewHolder, position: Int) {
        val receiver = getItem(position)
        holder.itemView.txtTime.text = receiver
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeViewHolder {
        return TimeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_time, parent, false)
        )
    }

    class TimeViewHolder(view: View) : RecyclerView.ViewHolder(view)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String) =
                oldItem == newItem
        }
    }
}
