package edu.austincc.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class FragmentShow extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
					
		// create Fragment
		String fname = getIntent().getStringExtra("FNAME");
		Fragment demo  = Fragment.instantiate(this, fname);
		// NOTICE: getSupportFragmentManager
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(android.R.id.content, demo);
		ft.commit();
		
	}



}
