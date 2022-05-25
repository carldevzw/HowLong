package com.grpprj.howlong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.ArrayList;

public class LauncherActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayList<UnisModel> unisModelArrayList;
    private final static int ERROR_DIALOG_REQUEST= 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        TextView tvWelcome= (TextView) findViewById(R.id.tvWelcome);
        TextView tvCampusPoint= (TextView) findViewById(R.id.tvCampusPoint);
        Button btnGetStarted=  (Button) findViewById(R.id.btnGetStarted);

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LauncherActivity.this, HomeViewActivity.class));
            }
        });
    }


}