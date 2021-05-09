package com.example.mapstarter;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        LatLng home = new LatLng(-0.9000098853025916, 119.84062968921036);
        LatLng museum = new LatLng(-0.9023784067079424, 119.85387459593669);
        mMap.addMarker(new MarkerOptions().position(home).title("Starting Marker").
                snippet("Fauzan's Home").icon(BitmapFromVector(getApplicationContext(),R.mipmap.ic_start)));
        mMap.addMarker(new MarkerOptions().position(museum).title("Museum").
                snippet("Museum Negeri Propinsi Sulawesi Tengah").icon(BitmapFromVector(getApplicationContext(),R.drawable.ic_finish)));
        mMap.addPolyline(new PolylineOptions().add(
                home,
                /** Jalan Cemara **/
                new LatLng(-0.900245520952895, 119.84061647458196),
                new LatLng(-0.9002555779908394, 119.8419522146803),
                new LatLng(-0.900242168602041, 119.84247323376685),
                new LatLng(-0.9002334524970822, 119.84261472029438),
                new LatLng(-0.9002166907595669, 119.84298754734415),
                new LatLng(-0.9001516552208478, 119.8439893524107),
                new LatLng(-0.9001462914649366, 119.84412815671834),
                new LatLng(-0.9001496855641331, 119.84426834789937),
                new LatLng(-0.9001490150946188, 119.84431461600192),
                new LatLng(-0.9001630767129976, 119.84500722886779),
                new LatLng(-0.9001972706564992, 119.8456583351076),
                new LatLng(-0.9002126914545023, 119.84573343695521),
                new LatLng(-0.9001665448486624, 119.84659040666077),
                new LatLng(-0.9001859884636626, 119.84701553678741),
                new LatLng(-0.9001836536259771, 119.84751902454347),
                /** Jalan Palola **/
                new LatLng(-0.9017977437634518, 119.84755100714288),
                /** Jalan Kunduri **/
                new LatLng(-0.9017903686023052, 119.84781855748841),
                new LatLng(-0.9018145054928757, 119.84817931459325),
                new LatLng(-0.9018654611505218, 119.84854677723584),
                new LatLng(-0.9018708249039014, 119.8486500422763),
                new LatLng(-0.9019271443145835, 119.84902756319715),
                new LatLng(-0.9019640201185605, 119.84935076938814),
                new LatLng(-0.9021084234876086, 119.85006605318992),
                new LatLng(-0.9022941434345885, 119.85217292836174),
                new LatLng(-0.9023196212606636, 119.85231441488952),
                new LatLng(-0.9025342571782667, 119.85314988533183),
                new LatLng(-0.9027407616429155, 119.85377752223333),
                museum
                ).width(20).color(Color.rgb(102, 157, 246))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 14.5f));
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
    }

    private BitmapDescriptor BitmapFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);

        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());

        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        vectorDrawable.draw(canvas);

        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}