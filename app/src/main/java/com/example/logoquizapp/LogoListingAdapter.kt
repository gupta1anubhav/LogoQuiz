package com.example.logoquizapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class LogoListingAdapter(val context: Context?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var logoDataList: List<LogoListingItem>? = listOf()
    private var eventListener: LogoListingInteraction? = null

    fun setEventListener(eventListingInteraction: LogoListingInteraction) {
        this.eventListener = eventListingInteraction
    }

    fun setLogoDataList(logoDataList: List<LogoListingItem>) {
        this.logoDataList = logoDataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LogoListingViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.logo_listing_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        context?.let {
            Glide.with(it).load(logoDataList?.get(position)).transition(withCrossFade())
                .thumbnail(Glide.with(it).load(R.drawable.placeholder))
                .into((holder as? LogoListingViewHolder)?.iv)
        }
        (holder as? LogoListingViewHolder)?.iv?.setOnClickListener {
            eventListener?.onLogoClick(position)
        }
    }

    override fun getItemCount(): Int {
        return logoDataList?.size ?: 0
    }

    inner class LogoListingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var iv: ImageView = itemView.findViewById(R.id.iv)
    }

    interface LogoListingInteraction {
        fun onLogoClick(position: Int)
    }
}