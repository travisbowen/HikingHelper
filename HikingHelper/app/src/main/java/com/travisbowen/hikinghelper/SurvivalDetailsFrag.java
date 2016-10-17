package com.travisbowen.hikinghelper;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SurvivalDetailsFrag extends Fragment {

    public static final String TAG = "SurvivalDetailsFrag.TAG";


    public static SurvivalDetailsFrag newInstance(Bundle bundleExtras) {

        SurvivalDetailsFrag survivalDetailsFrag = new SurvivalDetailsFrag();
        survivalDetailsFrag.setArguments(bundleExtras);

        return survivalDetailsFrag;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((SurvivalActivityDetails)getActivity()).setActionBarTitle("Survival Steps");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.survival_details_fragment_layout, container, false);

        TextView nameTV = (TextView) view.findViewById(R.id.survival_name_TV);
        TextView step1TV = (TextView) view.findViewById(R.id.survival_step1_TV);
        TextView step2TV = (TextView) view.findViewById(R.id.survival_step2_TV);
        TextView step3TV = (TextView) view.findViewById(R.id.survival_step3_TV);
        TextView step4TV = (TextView) view.findViewById(R.id.survival_step4_TV);
        TextView step5TV = (TextView) view.findViewById(R.id.survival_step5_TV);
        TextView step6TV = (TextView) view.findViewById(R.id.survival_step6_TV);
        TextView step7TV = (TextView) view.findViewById(R.id.survival_step7_TV);
        TextView step8TV = (TextView) view.findViewById(R.id.survival_step8_TV);

        Bundle bundleExtras = getArguments();

        if (bundleExtras != null) {

            nameTV.setText(bundleExtras.getString("Name"));
            step1TV.setText(bundleExtras.getString("Step1"));
            step2TV.setText(bundleExtras.getString("Step2"));
            step3TV.setText(bundleExtras.getString("Step3"));
            step4TV.setText(bundleExtras.getString("Step4"));
            step5TV.setText(bundleExtras.getString("Step5"));
            step6TV.setText(bundleExtras.getString("Step6"));
            step7TV.setText(bundleExtras.getString("Step7"));
            step8TV.setText(bundleExtras.getString("Step8"));
        }
        return view;
    }

}

