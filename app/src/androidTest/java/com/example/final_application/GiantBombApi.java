package com.example.final_application;

import com.example.final_application.models.GiantBombSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiantBombApi {
    @GET("franchises/GIANT_BOMB_APIKEY")
    Call<GiantBombSearchResponse> getFranchise(
            @Query("name") String name,
            @Query("term") String term

    );
}
//https://www.giantbomb.com/api/franchises/?api_key=81ddcc9bf59c3f432f7a1dfa1827e28ee6fbc005&format=json&field_list=image,name,deck,concepts,date_added,date_last_updated,id