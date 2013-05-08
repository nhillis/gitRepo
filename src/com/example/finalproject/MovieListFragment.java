package com.example.finalproject;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MovieListFragment extends ListFragment {
	boolean mDualPane;
	int mCurCheckPosition = 0;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_activated_1, titles));
		
		
		View movieInfoFrame = getActivity().findViewById(R.id.details);
		mDualPane = movieInfoFrame != null && movieInfoFrame.getVisibility() == View.VISIBLE;
		
		
		if (savedInstanceState != null) {
			mCurCheckPosition = savedInstanceState.getInt("currChoice", 0);
		}
		
		if(mDualPane) {
			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			
			showDetails(mCurCheckPosition);
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("curChoice", mCurCheckPosition);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		showDetails(position);
	}
	
	
	
	void showDetails(int index) {
		mCurCheckPosition = index;
		
		if(mDualPane) {
			getListView().setItemChecked(index, true);
			
			DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
			
			if(details == null || details.getShownIndex() != index) {
				details = DetailsFragment.newInstance(index);
				
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				if(index == 0) {
					ft.replace(R.id.details, details);
				} else {
					ft.replace(R.id.a_item, details);
				}
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.commit();
			}
		} else {
			Intent intent = new Intent();
			intent.setClass(getActivity(), MainActivity.class);
			intent.putExtra("index", index);
			startActivity(intent);
		}
	}
}
