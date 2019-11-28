package com.example.final_application;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private Retrofit retrofit=null;

    private GiantBombService giantServices = null;
    private Context context;

    public ApiClient(Context context) {
        this.context = context;
    }


    public GiantBombService getGiantServices() {

        if(retrofit == null){
            OkHttpClient.Builder client = new OkHttpClient.Builder();
           /* if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
                client.addInterceptor(logging);
            }*/

            retrofit = new Retrofit.Builder().client(client.build())
                    .baseUrl(Config.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        giantServices = retrofit.create(GiantBombService.class);

        return giantServices;
    }
}
