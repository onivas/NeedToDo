package com.example.savino.needtodo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.savino.needtodo.databinding.ActivityMainBinding;
import com.example.savino.needtodo.model.Stargazers;
import com.example.savino.needtodo.networking.ApiManagerImpl;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = ">>>>>> RETROFIT:";
    private ActivityMainBinding mBinding;
    private ApiManagerImpl mApiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mApiManager = new ApiManagerImpl();

        Call<ArrayList<Stargazers>> result = mApiManager.listStargazers("onivas", "MenuAnimation");
        result.enqueue(new Callback<ArrayList<Stargazers>>() {
            @Override
            public void onResponse(Call<ArrayList<Stargazers>> call, Response<ArrayList<Stargazers>> response) {
                ArrayList<Stargazers> stargazerses = response.body();

                if (stargazerses.size() > 1) {
                    Stargazers stargazers = stargazerses.get(0);
                    mBinding.name.setText(stargazers.getLogin());
                    mBinding.surname.setText(stargazers.getAvatar());
                    mBinding.age.setText(stargazers.getId());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Stargazers>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}
