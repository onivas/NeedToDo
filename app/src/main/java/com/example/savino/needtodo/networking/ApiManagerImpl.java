package com.example.savino.needtodo.networking;


import com.example.savino.needtodo.model.Stargazers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

public class ApiManagerImpl implements ApiManager {

    private Retrofit mRetrofit;

    @Override
    public Call<ArrayList<Stargazers>> listStargazers(@Path("owner") String owner, @Path("repo") String repo) {
        return apiManager().listStargazers(owner, repo);
    }

    private ApiManager apiManager() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit.create(ApiManager.class);
    }
}
