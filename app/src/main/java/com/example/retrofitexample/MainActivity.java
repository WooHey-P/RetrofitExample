package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RetrofitService service = new RetrofitService();
    Button btn_call;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialize();

        btn_call.setOnClickListener(view -> {
            Map<String, String> param = new HashMap<>();
            param.put("userIdx", "1810");
            service.PostData("/api/Workshop/CreateUserWorkshop", param, new RetrofitListener() {
                @Override
                public void onResponse(Call call, Response response) {
                    Object obj = response.body();
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Throwable e = t;
                }
            });
        });
    }

    private void Initialize() {
        btn_call = findViewById(R.id.btn_call);
        tv_result = findViewById(R.id.tv_result);
    }
}