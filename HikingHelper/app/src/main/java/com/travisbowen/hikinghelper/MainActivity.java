package com.travisbowen.hikinghelper;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    public static final int PICK_CONTACT = 101;
    private static final String KEY_TRIP_NUMBER = "KEY_TRIP_NUMBER";
    private GoogleApiClient googleApiClient;
    Toolbar toolbar;
    TextView contactTextView;
    TextView numberTextView;
    String contact;
    String contactNumber;
    String contactID;
    boolean isHiking = false;
    Location loc = null;
    private double latitude = 0;
    private double longitude = 0;
    private SharedPreferences sharedpreferences;

    private Timer timer;
    private String MyPREFERENCES = "MyPref";
    private String tripId;
    private String customId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            toolbar.setLogo(R.mipmap.ic_launcher);
        }

        setSupportActionBar(toolbar);

        Button importButton = (Button) findViewById(R.id.importButton);
        Button startButton = (Button) findViewById(R.id.startButton);
        Button stopButton = (Button) findViewById(R.id.stopButton);

        contactTextView = (TextView) findViewById(R.id.contactTextView);
        numberTextView = (TextView) findViewById(R.id.numberTextView);

        importButton.setOnClickListener(this);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);

        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        googleApiClient.connect();
    }

    protected void onStop() {

        googleApiClient.disconnect();
        super.onStop();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.first_aid_menu, menu);
        getMenuInflater().inflate(R.menu.survival_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_firstaid) {

            Intent intent = new Intent(this, FirstAidActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_survival) {

            Intent intent = new Intent(this, SurvivalActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_google) {

            Intent intent = new Intent(this, GoogleActivity.class);
            startActivity(intent);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.importButton:
                importContact();
                break;

            case R.id.startButton:
                startHike();
                break;

            case R.id.stopButton:
                stopHike();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_CONTACT) {
            if (resultCode == RESULT_OK) {

                Uri contactData = data.getData();

                getAndSetContactName(contactData);
                getAndSetContactNumber(contactData);
            }
        }
    }


    public void showToastNetwork() {
        Toast.makeText(this, "You need an active cell signal before starting or stopping a hike.", Toast.LENGTH_LONG).show();
    }


    public void showToastContact() {
        Toast.makeText(this, "You need to import a personal contact before starting your hike.", Toast.LENGTH_LONG).show();
    }


    public void importContact() {

        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, PICK_CONTACT);
    }


    public void startHike() {
        if (contact != null && contactNumber != null) {
            tripId = String.valueOf(new Random().nextInt(100));

            customId = tripId + contactNumber.replaceAll("[^0-9]", "");
            final ConnectivityManager connectManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connectManager != null) {

                NetworkInfo networkInfo = connectManager.getActiveNetworkInfo();

                if (networkInfo.isAvailable()) {
                    isHiking = true;
//                    Log.d("startHike: ", "Network Available");
                    Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
                    if (lastLocation != null) {
                        latitude = lastLocation.getLatitude();
                        longitude = lastLocation.getLongitude();
                    }

//                    Log.d("startHike: ", latitude + "," + longitude + "");
                    //Send coordinates to Firebase.
                    GeoPointsObject geoPointsObject = new GeoPointsObject(latitude, longitude);
                    Firebase rootRef = new Firebase(HikerApplication.getFirebaseRootRef());
                    Firebase geoPointsref = rootRef.child("geopoints");
                    Firebase tripIdRef = geoPointsref.child(customId);
                    tripIdRef.setValue(geoPointsObject);

                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(
                                    googleApiClient);
                            if (lastLocation != null) {
                                latitude = lastLocation.getLatitude();
                                longitude = lastLocation.getLongitude();
                            }

                            Map<String, Object> newLocation = new HashMap<>();
                            newLocation.put("latitude", latitude);
                            newLocation.put("longitude", longitude);
                            Firebase rootRef = new Firebase(HikerApplication.getFirebaseRootRef());
                            Firebase tripIdRef = rootRef.child("geopoints").child(customId);
                            tripIdRef.child("locations").child(String.valueOf(Calendar.getInstance().getTime())).updateChildren(newLocation);
                        }
                    }, 1000 * 60 * 1, 1000 * 60 * 60);


                    //Send a text message to the contact with the custom Firebase id to get the geo coordinates.
                    String originalContactNumber = contactNumber;
                    String customId = tripId + contactNumber.replaceAll("[^0-9]", "");
                    String textMessage = "Someone you know is hiking. You can track the status using ID: " + customId + ".";

                    try {
                        SmsManager.getDefault().sendTextMessage(originalContactNumber, null, textMessage, null, null);
                        Toast.makeText(this, "Hike started and message has been sent.", Toast.LENGTH_LONG).show();
                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(), "Your sms has failed...",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    showToastNetwork();
                }
            }
        } else {
            showToastContact();
        }
    }


    public void stopHike() {
        if (contact != null && contactNumber != null) {

            if (isHiking) {
                ConnectivityManager connectManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

                if (connectManager != null) {

                    NetworkInfo networkInfo = connectManager.getActiveNetworkInfo();

                    if (networkInfo.isAvailable()) {
                        isHiking = false;
                        //Send hikers final geo location to Firebase.
                        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

                        if (lastLocation != null) {
                            latitude = lastLocation.getLatitude();
                            longitude = lastLocation.getLongitude();
                            Firebase rootRef = new Firebase(HikerApplication.getFirebaseRootRef());
                            Firebase geoPointsref = rootRef.child("geopoints");
                            Firebase tripIdRef = geoPointsref.child(customId);
                            Map<String, Object> newLocation = new HashMap<>();
                            newLocation.put("latitude", latitude);
                            newLocation.put("longitude", longitude);
                            tripIdRef.child("locations").child(String.valueOf("stophike: " + Calendar.getInstance().getTime())).updateChildren(newLocation);
                        }
                        SmsManager.getDefault().sendTextMessage(contactNumber, null, "The hiker you are monitoring is done and on their way home.", null, null);
//                        Log.d("startHike: ", "Hiking stopped");
                        timer.cancel();
                        sharedpreferences.edit().putInt(KEY_TRIP_NUMBER, sharedpreferences.getInt(KEY_TRIP_NUMBER, 1) + 1).apply();
                    } else {
                        showToastNetwork();
                    }
                }
            }
        } else {
            showToastContact();
        }
    }

    private void getAndSetContactName(Uri contactData) {

        Cursor cursor = getContentResolver().query(contactData, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {

            contact = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        }

        if (cursor != null) {
            cursor.close();
        }

        contactTextView.setText("Contact: " + contact);
    }


    private void getAndSetContactNumber(Uri contactData) {

        //Get Contact ID
        Cursor cursorID = getContentResolver().query(contactData,
                new String[]{ContactsContract.Contacts._ID},
                null, null, null);

        if (cursorID.moveToFirst()) {

            contactID = cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts._ID));
        }

        cursorID.close();


        // Using the contact ID now we will get contact phone contactNumber
        Cursor cursorPhone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},

                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                        ContactsContract.CommonDataKinds.Phone.TYPE + " = " +
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,

                new String[]{contactID},
                null);

        if (cursorPhone.moveToFirst()) {
            contactNumber = cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        }

        cursorPhone.close();

        numberTextView.setText("Number: " + contactNumber);
    }


    @Override
    public void onLocationChanged(Location location) {

        latitude = loc.getLatitude();
        longitude = loc.getLongitude();
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }


    @Override
    public void onProviderEnabled(String provider) {

        if (provider.equals(LocationManager.NETWORK_PROVIDER)) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }

//            locMgr.removeUpdates(this);
        }

    }


    @Override
    public void onProviderDisabled(String provider) {

        if (provider.equals(LocationManager.NETWORK_PROVIDER)) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }

//            locMgr.requestLocationUpdates(provider, 3600000, 4320, this);
        }

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
