package com.travisbowen.hikinghelper;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class GoogleActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap googleMap;
    private EditText inputEditText;
    private Button showTrailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_activity_layout);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        inputEditText = (EditText) findViewById(R.id.inputEditText);

        inputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                showMarkersInMap(v.getText().toString());
                return false;
            }
        });

        inputEditText.setOnClickListener(this);

        showTrailButton = (Button) findViewById(R.id.showTrailButton);
        showTrailButton.setOnClickListener(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inputEditText:
                break;

            case R.id.showTrailButton:
                String customId = inputEditText.getText().toString();
                showMarkersInMap(customId);
                break;

        }
    }

    private void showMarkersInMap(String customId) {
        if (customId.length() != 0) {

            Firebase rootRef = new Firebase(HikerApplication.getFirebaseRootRef());
            Firebase tripIdRef = rootRef.child("geopoints").child(customId);
            tripIdRef.child("locations").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() == null) {

                        Toast.makeText(GoogleActivity.this, "Fetching of location failed, Please try again later", Toast.LENGTH_LONG).show();
                        googleMap.clear();
                        inputEditText.setText("");
                    }

                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        LatLng location = new LatLng(postSnapshot.getValue(GeoPointsObject.Location.class).getLatitude(),
                                postSnapshot.getValue(GeoPointsObject.Location.class).getLongitude());

                        googleMap.addMarker(new MarkerOptions().position(location).title(String.valueOf(location)));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location));
                    }

                }

                public void onCancelled(FirebaseError firebaseError) {
                    Toast.makeText(GoogleActivity.this, "Fetching of location failed, Please try again later", Toast.LENGTH_LONG).show();
                    googleMap.clear();
                    inputEditText.setText("");
                }
            });
        } else {
            Toast.makeText(this, "Please enter a trip id to get the location", Toast.LENGTH_LONG).show();
        }
    }
}
