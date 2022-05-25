package com.grpprj.howlong;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.grpprj.howlong.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng astraCampus = new LatLng(-17.316536622302035, 31.323409198425715);
        mMap.addMarker(new MarkerOptions().position(astraCampus).title("Astra Campus"));

        LatLng townCampus = new LatLng(-17.311029569143724, 31.333782475320472);
        mMap.addMarker(new MarkerOptions().position(townCampus).title("Town Campus"));

        LatLng mainCampus = new LatLng(-17.324512901693048, 31.332894692236476);
        mMap.addMarker(new MarkerOptions().position(mainCampus).title("Main Campus"));

        LatLng fseCampus = new LatLng(-17.290355746124273, 31.34818686516035);
        mMap.addMarker(new MarkerOptions().position(fseCampus).title("FSE Campus"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(fseCampus, 15), 5000,null );

        /*LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(astraCampus);
        builder.include(townCampus);
        LatLngBounds bounds = builder.build();
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20));*/


    }
}