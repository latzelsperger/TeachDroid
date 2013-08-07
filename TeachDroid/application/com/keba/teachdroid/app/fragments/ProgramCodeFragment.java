package com.keba.teachdroid.app.fragments;

import com.keba.teachdroid.app.ProjectActivity;
import com.keba.teachdroid.app.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ProgramCodeFragment extends Fragment {

	private View mRootView;
	ProjectActivity callback;
	TextView t;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		mRootView = inflater.inflate(R.layout.fragment_program_code, container, false);
		callback = (ProjectActivity) getArguments().getSerializable("connector");
		t = (TextView) mRootView.findViewById(R.id.programCode);
		t.setText(callback.getProgramCode());
		return mRootView;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		t.setText(callback.getProgramCode());
	}

	public void setProgramCode() {
		t.setText(callback.getProgramCode());
	}
}