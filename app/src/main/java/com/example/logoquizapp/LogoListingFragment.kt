package com.example.logoquizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

class LogoListingFragment: Fragment(), LogoListingAdapter.LogoListingInteraction {
    companion object {
        const val TAG = "LogoListingFragment"
        fun newInstance(): LogoFragment {
            return LogoFragment()
        }
    }

    private var logoListingAdapter: LogoListingAdapter? = null
    private var viewModel: LogoListingViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logo_listing, container, false)    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupViews()
        observeEvents()
        viewModel?.loadPage()
    }

    fun observeEvents() {
        getViewModel()?.apply {
            viewModel = this
            logoListingResponsePageDataLD.observe(viewLifecycleOwner, {
                logoListingAdapter?.setLogoDataList(it)
            })
        }
    }

    private fun setupViews() {
        logoListingAdapter = LogoListingAdapter(context)
        logoListingAdapter.setEventListener(this)
        rv.adapter = logoListingAdapter
        rv.layoutManager = GridLayoutManager(context, 3)
    }

    private fun getViewModel(): LogoListingViewModel {
        return ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val service = RetrofitHelper.createRetrofitService(LogoListingService::class.java)
                val fetcher = LogoListingFetcherImpl(service)
                return LogoListingViewModel(fetcher) as T
            }
        }).get(LogoListingViewModel::class.java)
    }

    override fun onLogoClick(position: Int) {
        //call Logo activity from here
    }

}