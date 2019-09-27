package com.example.retrofitapplication.repository;

import com.example.retrofitapplication.retrofit.RetrofitInstance;
import com.example.retrofitapplication.retrofit.ShibeService;

import java.util.List;

import retrofit2.Call;

/*a central place where data is stored and maintained.*/

public class Repository {

    private Repository() {}

    static class RepositoryInstanceHolder {  /*modules are responsible for handling data operations.*/
        static Repository INSTANCE = new Repository();  /*Objects to store their states*/
        }

        public static Repository getInstance(){
        return RepositoryInstanceHolder.INSTANCE;
        }

        public Call<List<String>> getShibes(int count) {  /*constructor, known as a conversion
        constructor, initializes the new collection to contain all of the elements in the specified collection*/
            return RetrofitInstance
                    .getInstance()
                    .create(ShibeService.class)
                    .getShibies(count);
        } /*Returns the fields in formation*/



}
