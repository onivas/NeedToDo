package com.example.savino.needtodo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainFragment extends Fragment {

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        // You can create a Bundle and setArguments at the fragment
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView resultText = (TextView) view.findViewById(R.id.text_with_no_spaces);
        final EditText text = (EditText) view.findViewById(R.id.type_text);
        Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultString = replaceSpaceWithDash(text.getText().toString());
                resultText.setText(resultString);
            }
        });
    }

    private String replaceSpaceWithDash(String s) {
        return s.replaceAll(" ", "-");
    }
}
