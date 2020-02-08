package com.example.scrollflagsplayground;

/**
 * @author Evgeny Chumak
 **/
public class FlagItem {
    private final int mFlag;
    private final String mText;
    private boolean mIsSelected;

    public FlagItem(int flag, String text, boolean isSelected) {
        mFlag = flag;
        mText = text;
        mIsSelected = isSelected;
    }

    public int getFlag() {
        return mFlag;
    }

    public String getText() {
        return mText;
    }

    public boolean isSelected() {
        return mIsSelected;
    }

    public void setSelected(boolean selected) {
        mIsSelected = selected;
    }
}
