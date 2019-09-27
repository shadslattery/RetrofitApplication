package com.example.retrofitapplication.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitapplication.R;
import com.example.retrofitapplication.Shibes.ShibeAdapter;
import com.example.retrofitapplication.viewmodel.MainViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/*the synthetic task stack that will be generated during Up navigation from a different task.*/
public class MainActivity extends AppCompatActivity {
    //onCreate is the first lifecyle
    private MainViewModel viewModel;
    private RecyclerView rvShibes;
    private ShibeAdapter adapter;

    @Override /*method is overriding a method from the superclass.*/

    /*activity is started and application is not loaded, then both onCreate() methods will be called.*/
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*you tell the Dalvik VM to run your code in addition to the existing code in the onCreate() of the parent class*/

        /*retains ViewModels while a scope of given fragment*/
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        /*method that finds the view from the layout resource file that are attached with current Activity*/
        rvShibes = findViewById(R.id.rv_shibes);

        /*implementation which provides similar functionality to ListView.*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        /*Constructor used when layout manager is set in XML by RecyclerView attribute*/
        rvShibes.setLayoutManager(linearLayoutManager);

        /*means the RecyclerView has children (items) that has fixed width and height.*/
        rvShibes.setHasFixedSize(true);

        /* Returns 10 items */
        viewModel.getShibes(10).enqueue(new Callback<List<String>>() {


            /*method is overriding a method from the superclass.*/
            @Override

            /*handles successful calls, and onFailure handles failures*/
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                ShibeAdapter adapter = new ShibeAdapter(response.body());

                /*ViewGroup that gets its child views from an Adapter*/
                rvShibes.setAdapter(adapter);
            }

            /*method is overriding a method from the superclass.*/
            @Override

            /*Invoked when a network exception occurred talking to the server*/
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "This is fail or pass", Toast.LENGTH_SHORT).show();
                /*contains message to be displayed quickly and disappears after sometime.*/
            }
        });
    }
}
