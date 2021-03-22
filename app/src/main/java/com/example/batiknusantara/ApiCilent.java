package com.example.batiknusantara;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCilent {
    private  static  final  String BASE_URL="https://batikita.herokuapp.com/index.php/batik/";
    private static Retrofit retrofit;
    public static Retrofit ambilBatik(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}


