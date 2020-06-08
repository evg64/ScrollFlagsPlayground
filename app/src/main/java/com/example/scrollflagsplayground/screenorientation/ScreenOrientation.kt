package com.example.scrollflagsplayground.screenorientation

/**
 *
 *
 * @author Evgeny Chumak
 **/
data class ScreenOrientation(val orientation: Int, val title: String) {
    override fun toString() = title
}