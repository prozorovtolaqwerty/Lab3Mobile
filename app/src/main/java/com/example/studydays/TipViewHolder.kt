package com.example.studydays

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipViewHolder(
    itemView: View,
    private val onTipClick: (Tip) -> Unit,
) : RecyclerView.ViewHolder(itemView) {

    private val dayText: TextView = itemView.findViewById(R.id.dayText)
    private val titleText: TextView = itemView.findViewById(R.id.titleText)
    private val summaryText: TextView = itemView.findViewById(R.id.summaryText)
    private val tipImage: ImageView = itemView.findViewById(R.id.tipImage)
    private var currentTip: Tip? = null

    init {
        itemView.setOnClickListener {
            currentTip?.let(onTipClick)
        }
    }

    fun bind(tip: Tip) {
        currentTip = tip
        val context = itemView.context
        dayText.text = context.getString(R.string.day_label, tip.day)
        titleText.setText(tip.titleRes)
        summaryText.setText(tip.summaryRes)
        tipImage.setImageResource(tip.imageRes)
        tipImage.contentDescription = context.getString(tip.titleRes)
    }
}
