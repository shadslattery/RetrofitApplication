package com.example.retrofitapplication.Shibes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitapplication.R;
import java.util.List;

/*flexible and efficient version of ListView. larger data set of views that can be recycled
and scrolled very efficiently.*/
public class ShibeAdapter extends RecyclerView.Adapter<ShibeAdapter.ShibeViewHolder> {

    /*constructor, known as a conversion
        constructor, initializes the new collection to contain all of the elements in the specified collection*/
    private List<String> shibeUrls;
    private Context context; /*it represents the state surrounding where you are in your system*/

    public ShibeAdapter(List<String> shibeUrls) {
        this.shibeUrls = shibeUrls;
    }
    /*constructor, known as a conversion
        constructor, initializes the new collection to contain all of the elements in the specified collection*/

    @NonNull /*Denotes that a parameter, field or method return value can never be null.*/
    @Override /*method is overriding a method from the superclass.*/

    /*Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.*/
    public ShibeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext(); /*is passed down from the activity to the fragment to the
        RecyclerView - remember a view takes a context in it's constructor */

        /*View is the class name while view is the object of that class.*/
        View view = LayoutInflater.from(context).inflate(  /*it takes as input an XML file and builds the View objects from it.*/
                R.layout.shibe_item, /*static final int member that represents the ID of the layout-file in layout/activity_main*/
                parent,
                false);
        return new ShibeViewHolder(view);  /*is used to exit from a method, with or without a value.*/
    }

    @Override /*method is overriding a method from the superclass.*/

    /*VH holder, int position, List<Object> payloads) Called by RecyclerView to display the data at the specified position.*/
    public void onBindViewHolder(@NonNull ShibeViewHolder holder, int position) {
        /* Chages to a String *Text) */
        String shibeUrl = shibeUrls.get(position);

        /*to move smoothly and continuously along, as if without effort or resistance,*/
        Glide.with(context).load(shibeUrl).into(holder.ivShibeImage);
    }

    @Override /*method is overriding a method from the superclass.*/
    /*Returns the total number of items in the data set held by the adapter.*/
    public int getItemCount() {
        return shibeUrls.size();
    }

    /*caches views associated with the default Preference layouts.*/
    class ShibeViewHolder extends RecyclerView.ViewHolder {
        ImageView ivShibeImage;

        /*caches views associated with the default Preference layouts.*/
        /*Denotes that a parameter, field or method return value can never be null.*/
        ShibeViewHolder(@NonNull View itemView) {
            super(itemView);
            ivShibeImage = itemView.findViewById(R.id.iv_shibe_image);
            /*method that finds the view from the layout resource file that are attached with current Activity*/
        }
    }
}