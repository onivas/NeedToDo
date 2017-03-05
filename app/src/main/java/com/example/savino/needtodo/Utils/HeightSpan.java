package com.example.savino.needtodo.Utils;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

public class HeightSpan implements LineHeightSpan {

    private final int mHeight;

    public HeightSpan(int height) {
        mHeight = height;
    }

    @Override
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int v, Paint.FontMetricsInt fm) {
        fm.bottom += mHeight;
        fm.descent += mHeight;
    }
}

