package com.example.logoquizapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LogoActivity : AppCompatActivity() {

    companion object {
        const val INIT_MODEL = "init_model"

        fun getIntent(
            context: Context,
            initModel: LogoListingInitModel
        ): Intent {
            return Intent(context, LogoActivity::class.java).apply {
                putExtra(INIT_MODEL, initModel)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)
        addFragment()
    }
    private fun addFragment() {
        val initModel = intent.getSerializableExtra(LogoActivity.INIT_MODEL) as? LogoListingInitModel
        val fragment: LogoFragment? =
            supportFragmentManager.findFragmentByTag(LogoFragment.TAG) as? LogoFragment
        if (fragment == null) {
            initModel?.let {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.container,
                        LogoFragment.newInstance(it),
                        LogoFragment.TAG
                    )
                    .commitAllowingStateLoss()
            }
        }
    }
}