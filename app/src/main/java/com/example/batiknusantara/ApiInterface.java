package com.example.batiknusantara;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("all")
    Call<SemuaBatik>getsemuabatik();
}
