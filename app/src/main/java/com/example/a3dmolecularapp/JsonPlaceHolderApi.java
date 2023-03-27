package com.example.a3dmolecularapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET("v1/{id}/full")
    Call<List<FullStruture>> getFullStruture(@Path("id") String structureId);



}
