package edu.austincc.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ariannaharadon on 2/24/17.
 */

public class PuppyTest extends Fragment {
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        textView = new TextView(getActivity());
        textView.setText("Puppies eat kibble!!!!");
        return textView;

    }


}




