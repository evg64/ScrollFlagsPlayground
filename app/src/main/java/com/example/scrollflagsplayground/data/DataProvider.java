package com.example.scrollflagsplayground.data;

import android.content.res.Resources;

import com.example.scrollflagsplayground.scrollflags.CollapseMode;
import com.example.scrollflagsplayground.flagsadapter.FlagItem;
import com.example.scrollflagsplayground.R;
import com.google.android.material.appbar.AppBarLayout.LayoutParams;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Chumak
 **/
public class DataProvider {

    private final Resources mResources;

    public  List<FlagItem> getScrollFlagItems() {
        return Arrays.asList(
                new FlagItem(
                        LayoutParams.SCROLL_FLAG_SCROLL,
                        mResources.getString(R.string.scroll),
                        true
                ),
                new FlagItem(
                        LayoutParams.SCROLL_FLAG_SNAP,
                        mResources.getString(R.string.snap),
                        true
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
                        true
                )
        );
    }

    public DataProvider(Resources resources) {
        mResources = resources;
    }

    public List<CollapseMode> getCollapseModeItems() {
        return Arrays.asList(
                new CollapseMode(CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_OFF, mResources.getString(R.string.none)),
                new CollapseMode(CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN, mResources.getString(R.string.pin)),
                new CollapseMode(CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX, mResources.getString(R.string.parallax))
        );
    }

    public int calculateScrollFlags(List<FlagItem> items) {
        int result = 0;
        for (FlagItem item : items) {
            if (item.isSelected()) {
                result |= item.getFlag();
            }
        }
        return result;
    }

}
