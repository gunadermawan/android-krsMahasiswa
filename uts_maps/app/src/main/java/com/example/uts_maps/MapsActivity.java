package com.example.uts_maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {

    private GoogleMap mMap;
    public static final  String mapsMahasiswa[] = {"Sumatra","Jawa","Kalimantan","Bali","NTT","NTB","Papua"};
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        double lati,langi;
        switch (position){
            case 0:
                mMap.clear();
                LatLng sydney = new LatLng(4.0428335, 95.5277073);
                mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in sumatra"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                break;
            case 1:
                mMap.clear();
                LatLng tegal = new LatLng(-6.8705278, 109.09973);
                mMap.addMarker(new MarkerOptions().position(tegal).title("Marker in Tegal"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(tegal));
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                Toast.makeText(this, "Pilihan tidak tersedia", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}