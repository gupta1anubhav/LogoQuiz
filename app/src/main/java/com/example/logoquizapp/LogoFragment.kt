package com.example.logoquizapp

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager


class LogoFragment : Fragment() {
    companion object {
        const val TAG = "LogoFragment"
        const val INIT_MODEL = "init_model"

        fun newInstance(initModel: LogoListingInitModel): LogoFragment {
            return LogoFragment().apply {
                arguments = Bundle().also {
                    it.putSerializable(INIT_MODEL, initModel)
                }
            }
        }
    }

    private var initModel: LogoListingInitModel? = null
    private var letterSetAdapter: LetterSetAdapter? = null
    private var countDownTimer: CountDownTimer? = null
    private val handler: Handler = Handler()
    private val runnable: Runnable? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        unpackBundle(savedInstanceState ?: arguments)
        setupViews()
    }

    private fun unpackBundle(bundle: Bundle?) {
        initModel = bundle?.getSerializable(INIT_MODEL) as? LogoListingInitModel
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        if (countDownTimer != )
    }

    private fun setupViews() {
        letterSetAdapter = LetterSetAdapter(
            context,
            LogoQuizUtils.getCharset(initModel?.item?.name!!)
        )
        //Use synthetic import
        letterSetRv.adapter = letterSetAdapter
        // we can make grid layout dynamic
        letterSetRv.layoutManager = GridLayoutManager(context, 2)

        // counntdown timer
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000)
            }
        }
    }

}