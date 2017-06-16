package com.example.savino.needtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.savino.needtodo.model.Person;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = ">>>>> TAG: ";

    public Person mPerson;

    onButtonClicked mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ModelComponent modelComponent = DaggerModelComponent.builder()
//                .modelModule(new ModelModule())
//                .build();
//
//        mPerson = modelComponent.providePerson();

        MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment);
        if (fragment != null && fragment instanceof onButtonClicked) {
            mListener = (onButtonClicked) fragment;
        }

        final EditText editText = (EditText) findViewById(R.id.edit_text);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.buttonClicked(editText.getText().toString());
            }
        });

//        Log.d(TAG, mPerson.getName() + " " + mPerson.getSurname() + " " + String.valueOf(mPerson.getAge()));


    }

    public interface onButtonClicked {
        void buttonClicked(String editTextValue);
    }
}
