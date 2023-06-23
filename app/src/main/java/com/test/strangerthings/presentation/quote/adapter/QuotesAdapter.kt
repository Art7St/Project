package com.test.strangerthings.presentation.quote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.test.strangerthings.R
import com.test.strangerthings.data.model.QuotesItem
import com.test.strangerthings.presentation.quote.QuotesFragmentDirections

class QuotesAdapter(private val navController: NavController) : RecyclerView.Adapter<QuotesAdapter.MyViewHolder>() {
    private var list = emptyList<QuotesItem>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quoteText: TextView = itemView.findViewById(R.id.quoteTextView)
        val authorText: TextView = itemView.findViewById(R.id.authorTextView)
        val cardView: LinearLayout = itemView.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.sample_quotes_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.quoteText.text = list[position].quote
        holder.authorText.text = list[position].author
        holder.cardView.setOnClickListener {
            navController.navigate(QuotesFragmentDirections.actionQuotesFragmentToDetailsFragment(list[position]))
        }
    }

    fun setData(newList: List<QuotesItem>) {
        list = newList
        notifyDataSetChanged()
    }
}