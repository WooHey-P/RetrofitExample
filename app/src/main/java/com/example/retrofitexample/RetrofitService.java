package com.example.retrofitexample;

import android.security.identity.ResultData;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String URL = "http://13.125.255.164:8880";

    public void PostData(String subUrl, Map<String, String> params, RetrofitListener listener){
        try{
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL + subUrl+"/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            RetrofitCall retrofitCall = retrofit.create(RetrofitCall.class);
            retrofitCall.PostData(params).enqueue(new Callback<DataModel>() {
                @Override
                public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                    listener.onResponse(call, response);
                }

                @Override
                public void onFailure(Call<DataModel> call, Throwable t) {
                    listener.onFailure(call, t);
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
