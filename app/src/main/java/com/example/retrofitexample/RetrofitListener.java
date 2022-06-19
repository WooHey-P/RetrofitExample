package com.example.retrofitexample;

import retrofit2.Call;
import retrofit2.Response;

public interface RetrofitListener<T> {
    void onResponse(Call<T> call, Response<T> response);
    void onFailure(Call<T> call, Throwable t);
}
