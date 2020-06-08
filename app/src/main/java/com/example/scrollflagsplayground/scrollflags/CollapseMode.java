package com.example.scrollflagsplayground.scrollflags;

import androidx.annotation.NonNull;

/**
 * @author Evgeny Chumak
 **/
public class CollapseMode {
    private final int mMode;
    private final String mText;

    public CollapseMode(int mode, String text) {
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
