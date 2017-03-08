package com.example.savino.needtodo.networking;


import com.example.savino.needtodo.model.Stargazers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiManager {

    @GET("/repos/{owner}/{repo}/stargazers")
    Call<ArrayList<Stargazers>> listStargazers(@Path("owner") String owner, @Path("repo") String repo);
}
