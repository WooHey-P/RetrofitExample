package com.example.retrofitexample;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface RetrofitCall {
    @GET
    Call<DataModel> GetData(@QueryMap HashMap<String, String> params);

    @POST("")
    Call<DataModel> PostData(@QueryMap Map<String, String> params);
}
