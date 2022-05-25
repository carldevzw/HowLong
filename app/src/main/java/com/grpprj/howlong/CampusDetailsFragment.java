package com.grpprj.howlong;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CampusDetailsFragment extends Fragment {
    private static final String TAG = "CampusDetailsFragment";
    private ArrayList<CampusModel> campusModelArrayList;
    private FirebaseFirestore db;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_campus_details, container, false);

        initRecyclerView(view);
        return view;
    }

    public void initRecyclerView(View view){

        RecyclerView campusDetailsRecyclerView= view.findViewById(R.id.rvCampusesList);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity());

        campusDetailsRecyclerView.setLayoutManager(linearLayoutManager);

        campusModelArrayList = new ArrayList<>();

        db= FirebaseFirestore.getInstance();

        db.collection("Campuses")
                .orderBy("Name", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error != null){
                            Log.w(TAG, "Database exception", error);
                        }else {
                            assert value != null;
                            for(DocumentChange dc: value.getDocumentChanges()){
                                if(dc.getType()== DocumentChange.Type.ADDED){
                                    campusModelArrayList.add(dc.getDocument().toObject(CampusModel.class));
                                }
                                CampsAdapter campsAdapter= new CampsAdapter(getActivity(), campusModelArrayList);
                                campusDetailsRecyclerView.setAdapter(campsAdapter);
                                campsAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }
}