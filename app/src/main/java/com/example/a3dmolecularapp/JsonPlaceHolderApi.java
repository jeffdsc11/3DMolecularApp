package com.example.a3dmolecularapp;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    @GET("v1/{id}/full")
    Call<ResponseBody> getFullStructure(@Path("id") String structureId);
}
