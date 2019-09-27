package com.example.retrofitapplication.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*It is a collection of abstract methods.*/

public interface ShibeService {

    /* The method takes one parameter
    key_element of object type and refers to the key whose associated value is supposed to be fetched.*/
    @GET(Constants.SHIBE_PATH)
    Call<List<String>> getShibies(@Query("count")int count);
/*constructor, known as a conversion
        constructor, initializes the new collection to contain all of the elements in the
        specified collection*/
        /*The Java Persistence Query Language (JPQL) is a platform-independent object-oriented query
        language defined as part of the Java Persistence API (JPA) specification.*/

}
