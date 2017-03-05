package com.example.savino.needtodo;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Toast;

import com.example.savino.needtodo.Utils.HeightSpan;
import com.example.savino.needtodo.databinding.ActivityMainBinding;
import com.example.savino.needtodo.model.Person;

public class MainActivity extends AppCompatActivity {

    // The name is the camel case of same of the layout inflated + Binding
    // activity_main --> ActivityMainBinding
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Person person = new Person("Savino", "Ordine", 32, true);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //mBinding.setPerson(person);

        SpannableStringBuilder builder = new SpannableStringBuilder();

        builder.append("This string has multiple span\nand it has also multiple lines")
                .append("\n")
                .append("because it is too long!");

        // Set LINE HEIGHT span
        builder.setSpan(new HeightSpan(getResources().getDimensionPixelSize(R.dimen.dp10)), 0, builder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Set FONT COLOR
        builder.setSpan(new ForegroundColorSpan(Color.LTGRAY), 5, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new ForegroundColorSpan(Color.MAGENTA), 37, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Set BACKGROUND COLOR
        builder.setSpan(new BackgroundColorSpan(Color.BLUE), 55, 60, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Set BOLD FONT
        builder.setSpan(new StyleSpan(Typeface.BOLD | Typeface.ITALIC), 62, 66, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Set CLICKABLE text
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(widget.getContext(), "Clicked!", Toast.LENGTH_SHORT).show();
            }
        };
        builder.setSpan(clickableSpan, 67, 75, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mBinding.name.setMovementMethod(LinkMovementMethod.getInstance());
        // Set UNDERLINE and STRIKETHROUGH
        builder.setSpan(new UnderlineSpan(), 78, 81, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new StrikethroughSpan(), 81, 83, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // SCALE the text x 3
        builder.setSpan(new ScaleXSpan(3.0f), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mBinding.name.setText(builder);

        doNotDoInThisWay();
    }

    // @Note: DO NOT reause the same Span multiple times
    private void doNotDoInThisWay() {
        SpannableString spannableString = new SpannableString("Only one span is working here!");

        // Create the span once
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);

        // Re-use it multiple times
        spannableString.setSpan(boldSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);  // Not working here
        spannableString.setSpan(boldSpan, 8, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // Not working here
        spannableString.setSpan(boldSpan, 15, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// Working here

        mBinding.surname.setText(spannableString);
    }
}
