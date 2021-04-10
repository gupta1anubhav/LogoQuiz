package com.example.logoquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LogoListingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo_listing)
        addFragment()
    }

    private fun addFragment() {
        val fragment: LogoListingFragment? =
            supportFragmentManager.findFragmentByTag(LogoFragment.TAG) as? LogoListingFragment
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.container,
                    LogoListingFragment.newInstance(),
                    LogoListingFragment.TAG
                )
                .commitAllowingStateLoss()
        }
    }
}