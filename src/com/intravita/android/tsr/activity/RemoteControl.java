package com.intravita.android.tsr.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.intravita.android.tsr.DemoApplication;
import com.intravita.android.tsr.R;
import com.intravita.android.tsr.fragment.dialog.UserDataValidationDialogFragment;

public class RemoteControl extends SherlockFragmentActivity implements UserDataValidationDialogFragment.UserDataValidationDialogListener {
	private static SharedPreferences mPrefs = DemoApplication.getPrefs();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remote_control);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		if (!mPrefs.getBoolean("PREF_DATA_ENTERED", false)) {
			showCatchDataDialog();
		}
	}
	
	private void showCatchDataDialog() {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
		
		if (prev != null) {
			ft.remove(prev);
		}
		ft.addToBackStack(null);
		ft.commit();
		
		SherlockDialogFragment fragment = new UserDataValidationDialogFragment();
		fragment.show(getSupportFragmentManager(), "dialog");
	}

	@Override
	public void onDataCompleted(Bundle icicle) {
		Toast.makeText(this, "Faking Data Transfer", Toast.LENGTH_SHORT).show();
		
		/**
		 * TODO:
		 */
		
		// Faking Data Transfer
	}
}