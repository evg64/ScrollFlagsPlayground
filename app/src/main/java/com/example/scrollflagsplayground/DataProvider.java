package com.example.scrollflagsplayground;

import android.content.res.Resources;

import com.google.android.material.appbar.AppBarLayout.LayoutParams;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Chumak
 **/
class DataProvider {

    private final Resources mResources;

    DataProvider(Resources resources) {
        mResources = resources;
    }

    List<FlagItem> getScrollFlagItems() {
        return Arrays.asList(
                new FlagItem(
                        LayoutParams.SCROLL_FLAG_SCROLL,
                        mResources.getString(R.string.scroll),
                        true
                ),
                new FlagItem(
                        LayoutParams.SCROLL_FLAG_SNAP,
                        mResources.getString(R.string.snap),
                        false
                ),
                new FlagItem(
                        LayoutParams.SCROLL_FLAG_ENTER_ALWAYS,
                        mResources.getString(R.string.enter_always),
                        false
                ),
                new FlagItem(
                        LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED,
                        mResources.getString(R.string.enter_always_collapsed),
                        false
                ),
                new FlagItem(
                        LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED,
                        mResources.getString(R.string.exit_until_collapsed),
                        false
                )
        );
    }

    List<CollapseMode> getCollapseModeItems() {
        return Arrays.asList(
                new CollapseMode(CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_OFF, mResources.getString(R.string.none)),
                new CollapseMode(CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN, mResources.getString(R.string.pin)),
                new CollapseMode(CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX, mResources.getString(R.string.parallax))
        );
    }

    int calculateScrollFlags(List<FlagItem> items) {
        int result = 0;
        for (FlagItem item : items) {
            if (item.isSelected()) {
                result |= item.getFlag();
            }
        }
        return result;
    }
}
