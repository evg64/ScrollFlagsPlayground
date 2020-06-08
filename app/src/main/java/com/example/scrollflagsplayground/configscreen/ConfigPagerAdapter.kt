package com.example.scrollflagsplayground.configscreen

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.scrollflagsplayground.R
import com.example.scrollflagsplayground.screenorientation.ScreenOrientationFragment
import com.example.scrollflagsplayground.scrollflags.ScrollFlagsFragment

/**
 *
 *
 * @author Evgeny Chumak
 **/
class ConfigPagerAdapter(manager: FragmentManager, private val context: Context) :
    FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val POSITION_SCROLL_FLAGS = 0
        private const val POSITION_SCREEN_ORIENTATION = 1
        private val pageTitles = listOf(R.string.scroll_flags, R.string.screen_orientation)
        private val FRAGMENT_COUNT = pageTitles.size
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            POSITION_SCROLL_FLAGS -> ScrollFlagsFragment()
            POSITION_SCREEN_ORIENTATION -> ScreenOrientationFragment()
            else -> throw IllegalArgumentException("Position $position is not supported")
        }

    override fun getPageTitle(position: Int) = context.getString(pageTitles[position])

    override fun getCount(): Int = FRAGMENT_COUNT
}