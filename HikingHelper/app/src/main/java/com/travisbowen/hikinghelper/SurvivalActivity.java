package com.travisbowen.hikinghelper;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SurvivalActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survival_activity_layout);

        FragmentManager fragMgr = getFragmentManager();
        FragmentTransaction fragTrans = fragMgr.beginTransaction();
        SurvivalFragment frag = SurvivalFragment.newInstance();
        fragTrans.replace(R.id.survival_fragment_frame, frag, SurvivalFragment.TAG);

        fragTrans.commit();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
    }
}
