package com.example.savino.needtodo.networking;


import com.example.savino.needtodo.model.Stargazers;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiManager {

    @GET("/repos/{owner}/{repo}/stargazers")
    Observable<List<Stargazers>> listStargazers(@Path("owner") String owner, @Path("repo") String repo);
}
