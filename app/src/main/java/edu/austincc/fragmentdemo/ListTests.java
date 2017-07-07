package edu.austincc.fragmentdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListTests extends ListFragment {
	boolean showTwoFragments;
	int curPos = -1;
	
	String tests[] = {"PuppyTest","CatTest","HorseTest","BirdTest",};
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		// for v4 support compatibility
		// java uses simple_list_item_1 instead of newer simple_list_item_activated_1
		// xml uses fragment (lowercase in xml file)
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, tests));
		View demoFrame = getActivity().findViewById(R.id.fieldentry);
		
		showTwoFragments =  demoFrame != null && demoFrame.getVisibility() == View.VISIBLE;
		
		if (savedInstanceState != null) {
			curPos = savedInstanceState.getInt("curChoice", 0);
		}
		if  (curPos != -1) {
			viewDemo(curPos);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	    // Save the user's current game state
	    savedInstanceState.putInt("curChoice", curPos);
	    
	    // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}	
	
	@Override
	public void onListItemClick(ListView list, View view, 
			int position, long id) 	{
		curPos = position;
		viewDemo(position);
	}
	
	public void viewDemo(int position) {
		
		String fname = "edu.austincc.fragmentdemo."+tests[position];
		
		if (showTwoFragments == true) {
			
			Fragment demo  = Fragment.instantiate(getActivity(), fname);			
			FragmentManager fm = getFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.fieldentry, demo);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			
		} else {
			Intent intent = new Intent();
			intent.setClass(getActivity(), FragmentShow.class);
			intent.putExtra("FNAME", fname);
			startActivity(intent);
			
		}
	}
}
