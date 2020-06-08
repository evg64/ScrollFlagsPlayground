package com.example.scrollflagsplayground.screenorientation

import android.content.pm.ActivityInfo
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.scrollflagsplayground.R
import kotlinx.android.synthetic.main.fragment_screen_orientation.*

/**
 *
 *
 * @author Evgeny Chumak
 **/
class ScreenOrientationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_screen_orientation, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinnerScreenOrientation.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            getScreenOrientations(resources)
        )
        buttonGo.setOnClickListener {
            ScreenOrientationActivity.launch(
                requireActivity(),
                (spinnerScreenOrientation.selectedItem as ScreenOrientation).orientation
            )
        }
    }

    private fun getScreenOrientations(resources: Resources): List<ScreenOrientation> = mutableListOf(
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED,
            resources.getString(R.string.orientation_unspecified)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_BEHIND,
            resources.getString(R.string.orientation_behind)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE,
            resources.getString(R.string.orientation_landscape)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT,
            resources.getString(R.string.orientation_portrait)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_USER,
            resources.getString(R.string.orientation_user)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_SENSOR,
            resources.getString(R.string.orientation_sensor)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_NOSENSOR,
            resources.getString(R.string.orientation_nosensor)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE,
            resources.getString(R.string.orientation_sensor_landscape)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT,
            resources.getString(R.string.orientation_sensor_portrait)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
            resources.getString(R.string.orientation_reverse_landscape)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT,
            resources.getString(R.string.orientation_reverse_portrait)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR,
            resources.getString(R.string.orientation_full_sensor)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE,
            resources.getString(R.string.orientation_user_landscape)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT,
            resources.getString(R.string.orientation_user_portrait)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_FULL_USER,
            resources.getString(R.string.orientation_full_user)
        ),
        ScreenOrientation(
            ActivityInfo.SCREEN_ORIENTATION_LOCKED,
            resources.getString(R.string.orientation_locked)
        )
    ).apply {
        sortWith(Comparator { left, right -> left.title.compareTo(right.title) })
    }
}