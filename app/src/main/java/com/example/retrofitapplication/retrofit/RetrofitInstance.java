package com.example.retrofitapplication.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance  {

    // Step 1: Create a Private Constructor
    private RetrofitInstance() {

    }
 // Step 2: Create Inner class to provide instance of Retrofit
    private static class RetrofitInstanceHolder {
     // Create a Retrofit Instance
     static Retrofit INSTANCE = new Retrofit.Builder()
             .baseUrl(Constants.BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build();
 }

    // Step 3: PUBLIC static method to access the instance of Retrofit
    public static Retrofit getInstance() {
        return RetrofitInstanceHolder.INSTANCE;
     }

     // Step 3 cont: This is a optimized way for Retrofit
    public static <S> S createService(Class<S> serviceClass) {
        return RetrofitInstanceHolder.INSTANCE.create(serviceClass);
     }


    }