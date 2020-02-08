package com.example.scrollflagsplayground;

import androidx.annotation.NonNull;

/**
 * @author Evgeny Chumak
 **/
class CollapseMode {
    private final int mMode;
    private final String mText;

    CollapseMode(int mode, String text) {
        mMode = mode;
        mText = text;
    }

    @NonNull
    @Override
    public String toString() {
        return mText;
    }

    public int getMode() {
        return mMode;
    }

    public String getText() {
        return mText;
    }
}
