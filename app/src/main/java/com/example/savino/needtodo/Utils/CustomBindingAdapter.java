package com.example.savino.needtodo.Utils;

import android.databinding.BindingAdapter;
import android.view.View;

public class CustomBindingAdapter {

    // Set different padding based on {value}
    @BindingAdapter("addLeftPadding")
    public static void setAddLeftPadding(View v, boolean value) {
        if (value) {
            v.setPadding((int) Conversion.convertPixelsToDp(20, v.getContext()),
                    v.getPaddingTop(),
                    v.getPaddingRight(),
                    v.getPaddingBottom()
            );

        } else {
            v.setPadding((int) Conversion.convertPixelsToDp(200, v.getContext()),
                    v.getPaddingTop(),
                    v.getPaddingRight(),
                    v.getPaddingBottom()
            );
        }
    }
}
