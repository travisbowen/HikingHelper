package com.travisbowen.hikinghelper;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SurvivalActivityDetails extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survival_details_activity_layout);

        Bundle bundleExtras = new Bundle();

        Intent intentExtras = getIntent();

        if (intentExtras != null){

            String name = intentExtras.getStringExtra("Name");
            String step1 = intentExtras.getStringExtra("Step1");
            String step2 = intentExtras.getStringExtra("Step2");
            String step3 = intentExtras.getStringExtra("Step3");
            String step4 = intentExtras.getStringExtra("Step4");
            String step5 = intentExtras.getStringExtra("Step5");
            String step6 = intentExtras.getStringExtra("Step6");
            String step7 = intentExtras.getStringExtra("Step7");
            String step8 = intentExtras.getStringExtra("Step8");

            bundleExtras.putString("Name", name);
            bundleExtras.putString("Step1", step1);
            bundleExtras.putString("Step2", step2);
            bundleExtras.putString("Step3", step3);
            bundleExtras.putString("Step4", step4);
            bundleExtras.putString("Step5", step5);
            bundleExtras.putString("Step6", step6);
            bundleExtras.putString("Step7", step7);
            bundleExtras.putString("Step8", step8);
        }

        SurvivalDetailsFrag frag = SurvivalDetailsFrag.newInstance(bundleExtras);

        FragmentManager fragMgr = getFragmentManager();
        FragmentTransaction fragTrans = fragMgr.beginTransaction();

        fragTrans.replace(R.id.survival_details_fragment_frame, frag, SurvivalDetailsFrag.TAG);

        fragTrans.commit();
    }


    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
    }
}
