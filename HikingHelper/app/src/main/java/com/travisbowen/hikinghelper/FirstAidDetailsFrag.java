package com.travisbowen.hikinghelper;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstAidDetailsFrag extends Fragment{

    public static final String TAG = "FirstAidDetailsFrag.TAG";


    public static FirstAidDetailsFrag newInstance(Bundle bundleExtras) {

        FirstAidDetailsFrag firstAidDetailsFrag = new FirstAidDetailsFrag();
        firstAidDetailsFrag.setArguments(bundleExtras);

        return firstAidDetailsFrag;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((FirstAidActivityDetails)getActivity()).setActionBarTitle("First Aid Steps");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.firstaid_details_fragment_layout, container, false);

        TextView nameTV = (TextView) view.findViewById(R.id.firstaid_name_TV);
        TextView step1TV = (TextView) view.findViewById(R.id.firstaid_step1_TV);
        TextView step2TV = (TextView) view.findViewById(R.id.firstaid_step2_TV);
        TextView step3TV = (TextView) view.findViewById(R.id.firstaid_step3_TV);
        TextView step4TV = (TextView) view.findViewById(R.id.firstaid_step4_TV);
        TextView step5TV = (TextView) view.findViewById(R.id.firstaid_step5_TV);
        TextView step6TV = (TextView) view.findViewById(R.id.firstaid_step6_TV);

        Bundle bundleExtras = getArguments();

        if (bundleExtras != null) {

            nameTV.setText(bundleExtras.getString("Name"));
            step1TV.setText(bundleExtras.getString("Step1"));
            step2TV.setText(bundleExtras.getString("Step2"));
            step3TV.setText(bundleExtras.getString("Step3"));
            step4TV.setText(bundleExtras.getString("Step4"));
            step5TV.setText(bundleExtras.getString("Step5"));
            step6TV.setText(bundleExtras.getString("Step6"));
        }
        return view;
    }

}
