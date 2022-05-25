package com.grpprj.howlong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeViewActivity extends AppCompatActivity implements UnisAdapter.OnUnisListener {
    private static final String TAG = "HomeActivity";
    private ArrayList<UnisModel> unisModelArrayList;
    RecyclerView unisListRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);

        unisListRV = findViewById(R.id.rvUnisList);

        unisModelArrayList = new ArrayList<>();
        unisModelArrayList.add(new UnisModel("Bindura University", "5", R.drawable.buse_logo));
        unisModelArrayList.add(new UnisModel("University of Zimbabwe", "3", R.drawable.uz_logo));
        unisModelArrayList.add(new UnisModel("Lupane State University", "6", R.drawable.lsu_logo));
        unisModelArrayList.add(new UnisModel("Midlands State University", "3", R.drawable.msu_logo));
        unisModelArrayList.add(new UnisModel("Africa University", "2", R.drawable.au_logo));
        unisModelArrayList.add(new UnisModel("Great Zimbawe University", "7", R.drawable.gzu_logo));
        unisModelArrayList.add(new UnisModel("Chinhoyi University", "5", R.drawable.cut_logo));

        UnisAdapter unisAdapter = new UnisAdapter(HomeViewActivity.this, unisModelArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeViewActivity.this, LinearLayoutManager.VERTICAL, false);

        unisListRV.setLayoutManager(linearLayoutManager);
        unisListRV.setAdapter(unisAdapter);
    }

    @Override
    public void onUniClick(int position) {
        unisModelArrayList.get(position);

        switch (position){
            case 0: {
                startActivity(new Intent(HomeViewActivity.this, MapsActivity.class));
                break;
            } default:{
                Toast.makeText(HomeViewActivity.this, "Not available.", Toast.LENGTH_SHORT).show();
            }

        }

    }
}