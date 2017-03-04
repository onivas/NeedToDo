package com.example.savino.needtodo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
        mBinding.setPerson(person);

    }
}
