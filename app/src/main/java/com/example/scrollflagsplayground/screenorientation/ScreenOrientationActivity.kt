package com.example.scrollflagsplayground.screenorientation

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.scrollflagsplayground.R

/**
 *
 *
 * @author Evgeny Chumak
 **/
class ScreenOrientationActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_SCREEN_ORIENTATION = "EXTRA_SCREEN_ORIENTATION"

        fun launch(from: Activity, screenOrientation: Int) =
            Intent(from, ScreenOrientationActivity::class.java)
                .run {
                    putExtra(EXTRA_SCREEN_ORIENTATION, screenOrientation)
                    from.startActivity(this)
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = intent.getIntExtra(
            EXTRA_SCREEN_ORIENTATION,
            ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        )
        setContentView(R.layout.activity_screen_orientation)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

}