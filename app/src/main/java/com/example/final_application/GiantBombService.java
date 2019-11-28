package com.example.final_application;

import com.example.final_application.models.GiantBombSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiantBombService {
    @GET("/api/search")
    Call<GiantBombSearchResponse> getList(@Query("api_key") String api_key, @Query("page")int page, @Query("format") String format, @Query("query") String query, @Query("resources") String resources, @Query("filed_list") String filed_list, @Query("limit") int limit);

    @GET("/api/franchise")
    Call<GiantBombSearchResponse> getTopGames(@Query("api_key") String api_key,@Query("format") String format,@Query("filed_list") String filed_list,@Query("limit") int limit);

    @GET("/api/franchise")
    Call<GiantBombSearchResponse> getMoreGames(@Query("api_key") String api_key, @Query("page")int page, @Query("format") String format, @Query("query") String query, @Query("resources") String resources, @Query("filed_list") String filed_list, @Query("limit") int limit);


}
