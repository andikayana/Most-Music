package com.blikadek.popularmusic.rest;

import com.blikadek.popularmusic.model.top_track.ApiResponse;
import com.blikadek.popularmusic.model.top_artist.ApiResponseArtist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by M13x5aY on 15/08/2017.
 */

public interface ApiService {
    @GET("2.0/")
    Call<ApiResponse> getTopTracks(
            @Query("method") String method,
            @Query("api_key") String api_key,
            @Query("format") String format
    );

    @GET("2.0/")
    Call<ApiResponseArtist> getTopArtist(
            @Query("method") String method,
            @Query("api_key") String api_key,
            @Query("format") String format
    );
}
