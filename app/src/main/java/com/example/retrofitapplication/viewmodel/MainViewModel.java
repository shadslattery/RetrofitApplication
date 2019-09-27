package com.example.retrofitapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.retrofitapplication.repository.Repository;

import java.util.List;

import retrofit2.Call;

public class MainViewModel extends AndroidViewModel {

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    /*constructor, known as a conversion
        constructor, initializes the new collection to contain all of the elements in the specified collection*/
    public Call<List<String>> getShibes(int count) {
        return Repository.getInstance().getShibes(count);
        /* Return the information from the Repository */
    }

}
