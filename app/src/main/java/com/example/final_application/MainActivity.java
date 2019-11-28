package com.example.final_application;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.final_application.adapters.RvAdapter;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private final String JSON_URL="https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
//    private JsonArrayRequest request;
//    private RequestQueue requestQueue;
//    private List<Games> franchise1;
//    private List<Anime> lstAnime = new ArrayList<>();
//    private RecyclerView recyclerView;
    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<Anime> lstAnime = new ArrayList<>();
    private RecyclerView myrv ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        myrv = findViewById(R.id.recyclerView);
        jsonrequest();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
    }
    public void jsonrequest() {


        ArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;


                for (int i = 0 ; i<response.length();i++) {

                    //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                    try {

                        jsonObject = response.getJSONObject(i);
                        Anime anime = new Anime();

                        anime.setName(jsonObject.getString("name"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setImage_url(jsonObject.getString("img"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setCategorie(jsonObject.getString("categorie"));
                        //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                        lstAnime.add(anime);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                Toast.makeText(MainActivity.this,"Size of Liste "+String.valueOf(lstAnime.size()),Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,lstAnime.get(1).toString(),Toast.LENGTH_SHORT).show();

                setRvadapter(lstAnime);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(ArrayRequest);
    }

    public void setRvadapter (List<Anime> lst) {

        RvAdapter myAdapter = new RvAdapter(this,lst) ;
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu,menu);
//        return super.onCreateOptionsMenu(menu);
//
//    }



//    private void jsonrequest(){
//
//        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                JSONObject jsonObject = null;
//
//
//                for (int i = 0 ; i<response.length();i++) {
//
//                    Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();
//
//                    try {
//
//                        jsonObject = response.getJSONObject(i);
//
//
//                        Anime anime = new Anime();
//
//                        anime.setName(jsonObject.getString("name"));
//                        anime.setDescription(jsonObject.getString("description"));
//                        anime.setRating(jsonObject.getString("Rating"));
//                        anime.setCategorie(jsonObject.getString("categorie"));
//                        anime.setNb_episode(jsonObject.getInt("episode"));
//                        anime.setStudio(jsonObject.getString("studio"));
//                        anime.setImage_url(jsonObject.getString("img"));
//
//
//                        Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
//                        lstAnime.add(anime);
//                    }
//                    catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                Toast.makeText(MainActivity.this,"Size of Liste "+String.valueOf(lstAnime.size()),Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this,lstAnime.get(1).toString(),Toast.LENGTH_SHORT).show();
//
//
//                setuprecyclerview(lstAnime);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//
//            }
//        });
//
//        requestQueue = Volley.newRequestQueue(MainActivity.this);
//        requestQueue.add(request);
//    }


//Remember to uncoment this line of code

//    private void setuprecyclerview(List<Anime> lstAnime) {
//        RvAdapter myAdapter = new RvAdapter(this,lstAnime);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(myAdapter);
//    }

    @Override
    public boolean onNavigationItemSelected(@Nullable MenuItem item){
//        switch (item.getItemId()) {
//            case R.id.nav_schedule:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new CalendarView()).commit();
//
//                break;
//            case R.id.nav_home:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new createEvent()).commit();
//                break;
//
//            case R.id.nav_announcement:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new ViewEvent()).commit();
//                break;
//            case R.id.message:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new NotificationsFragment()).commit();
//                break;
//            case R.id.nav_settings:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new NotificationsFragment()).commit();
//                break;
//        }
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
