package com.example.aiapiintegration;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AIAPIinterface {
@GET("api/show/{avg_marks}")
    Call<String> show_marks(@Path("avg_marks") Double avg_marks);
}
