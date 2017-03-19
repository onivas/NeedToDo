package com.example.savino.needtodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.savino.needtodo.di.DaggerModelComponent;
import com.example.savino.needtodo.di.ModelComponent;
import com.example.savino.needtodo.di.ModelModule;
import com.example.savino.needtodo.model.Person;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = ">>>>> TAG: ";

    public Person mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ModelComponent modelComponent = DaggerModelComponent.builder()
                .modelModule(new ModelModule())
                .build();

        mPerson = modelComponent.providePerson();

        Log.d(TAG, mPerson.getName() + " " + mPerson.getSurname() + " " + String.valueOf(mPerson.getAge()));
    }
}
