package com.ramanprabhakar.goshopping;

import com.ramanprabhakar.goshopping.model.ServerResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Raman on 5/22/2016.
 */
public interface RestService {


    @GET("/select")
    public void getHomePage1(@Query("q") String q, @Query("fl") List<String> flList, @Query("rows") String rows,
                             @Query("wt") String wt, Callback<ServerResponse> callback);

    @GET("/select")
    public void getHomePage2(@Query("q") String q, @Query("fl") List<String> flList,
                             @Query("rows") String rows, @Query("start") String start, @Query("wt") String wt, Callback<ServerResponse> callback);

    @GET("/select")
    public void getFilter1(@Query("q") String q, @Query("fq") String fq, @Query("fl") List<String> flList,
                           @Query("rows") String rows, @Query("wt") String wt, Callback<ServerResponse> callback);

    @GET("/select")
    public void getFilter2(@Query("q") String q, @Query("fq") String fq, @Query("fl") List<String> flList,
                           @Query("rows") String rows, @Query("start") String start, @Query("wt") String wt, Callback<ServerResponse> callback);

    @GET("/select")
    public void getDetails(@Query("q") String q, @Query("fq") String fq, @Query("fl") List<String> flList,
                           @Query("rows") String rows, @Query("wt") String wt, Callback<ServerResponse> callback);

}
