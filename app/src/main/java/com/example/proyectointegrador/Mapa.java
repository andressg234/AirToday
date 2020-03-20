package com.example.proyectointegrador;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private LocationManager locManager;
    private Location miLoc;
    private static final int PETICION_PERMISO_LOCALIZACION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    PETICION_PERMISO_LOCALIZACION);
        } else {
            Log.i("LOC", "con permisos");
            /*flClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    Log.i("LOC", "onSuccess de location");
                    if (location != null) {
                        miLoc = location;
                    }

                }

            });*/

            locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            miLoc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }

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

        LatLng madrid = new LatLng(40.4167047, -3.7035825);

        LatLng pzaEspaña = new LatLng(40.4238823, -3.7122567);
        mMap.addMarker(new MarkerOptions().position(pzaEspaña).title("Pza. De España"));

        LatLng escuelasAguirre = new LatLng(40.4215533, -3.6823158);
        mMap.addMarker(new MarkerOptions().position(escuelasAguirre).title("Escuelas Aguirre"));

        LatLng ramonYCajal = new LatLng(40.4514734, -3.6773491);
        mMap.addMarker(new MarkerOptions().position(ramonYCajal).title("Avda. Ramón y Cajal"));

        LatLng arturoSoria = new LatLng(40.4400457, -3.6392422);
        mMap.addMarker(new MarkerOptions().position(arturoSoria).title("Arturo Soria"));

        LatLng villaverde = new LatLng(40.347147, -3.7133167);
        mMap.addMarker(new MarkerOptions().position(villaverde).title("Villaverde"));

        LatLng farolillo = new LatLng(40.3947825, -3.7318356);
        mMap.addMarker(new MarkerOptions().position(farolillo).title("Farolillo"));

        LatLng casaDeCampo = new LatLng(40.4193577, -3.7473445);
        mMap.addMarker(new MarkerOptions().position(casaDeCampo).title("Casa De Campo"));

        LatLng barajasPueblo = new LatLng(40.4769179, -3.5800258);
        mMap.addMarker(new MarkerOptions().position(barajasPueblo).title("Barajas Pueblo"));

        LatLng pzaDelCarmen = new LatLng(40.4192091, -3.7031662);
        mMap.addMarker(new MarkerOptions().position(pzaDelCarmen).title("Pza. Del Carmen"));

        LatLng moratalaz = new LatLng(40.4079517, -3.6453104);
        mMap.addMarker(new MarkerOptions().position(moratalaz).title("Moratalaz"));

        LatLng cuatroCaminos = new LatLng(40.4455439, -3.7071303);
        mMap.addMarker(new MarkerOptions().position(cuatroCaminos).title("Cuatro Caminos"));

        LatLng barrioDelPilar = new LatLng(40.4782322, -3.7115364);
        mMap.addMarker(new MarkerOptions().position(barrioDelPilar).title("Barrio Del Pilar"));

        LatLng vallecas = new LatLng(40.3881478, -3.6515286);
        mMap.addMarker(new MarkerOptions().position(vallecas).title("Vallecas"));

        LatLng mendezAlvaro = new LatLng(40.3980991, -3.6868138);
        mMap.addMarker(new MarkerOptions().position(mendezAlvaro).title("Mendez Alvaro"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(madrid, 10));


        /*mMap = googleMap;

        LatLng uem = null;
        if (miLoc == null) {
            uem = new LatLng(40.535162, -3.6168482);
        } else {
            Log.i("miLoc", miLoc.getLatitude() + ", " + miLoc.getLongitude());
            uem = new LatLng(miLoc.getLatitude(), miLoc.getLongitude());
        }
        mMap.addMarker(new MarkerOptions().position(uem).title("UEM"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uem, 14));

        //mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Nueva posicion")
                        .snippet("Lat: " +latLng.latitude + ", Long: " + latLng.longitude)
                        .icon(BitmapDescriptorFactory.defaultMarker(
                                BitmapDescriptorFactory.HUE_GREEN))
                );
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            }
        });*/
    }
}
