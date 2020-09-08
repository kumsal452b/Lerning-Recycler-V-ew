package com.example.lerning_recycler_v_ew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExampleItemAdaptar exampleItemAdaptar;
    protected ArrayList<ExampleItem> exampleItems;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rec_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        exampleItems=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(this);
        parseJson();

    }
    private void parseJson(){
        String uri="https://pixabay.com/api/?key=18227087-3db30ac46e31758c6e47e066f&q=yellow+flowers&image_type=photo";
        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, uri, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array=response.getJSONArray("hits");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject hit=array.getJSONObject(i);
                        String creatorName=hit.getString("user");
                        String imageUrl=hit.getString("webformatURL");
                        int likes=hit.getInt("likes");
                        exampleItems.add(new ExampleItem(imageUrl,creatorName,likes));
                    }
                    exampleItemAdaptar=new ExampleItemAdaptar(MainActivity.this,exampleItems);
                    recyclerView.setAdapter(exampleItemAdaptar);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);

    }
}