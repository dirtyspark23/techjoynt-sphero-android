package com.intravita.android.tsr.fragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.intravita.android.tsr.DemoApplication;
import com.intravita.android.tsr.R;

public class UserDataValidationDialogFragment extends SherlockDialogFragment  {
	private static SharedPreferences mPrefs = DemoApplication.getPrefs();
	private static SharedPreferences.Editor editor = mPrefs.edit();
	
	private static final String PREF_DATA_ENTERED = "PREF_DATA_ENTERED";
	
	private EditText mFirstName, mLastName, mEmail;
	
	public interface UserDataValidationDialogListener {
		void onDataCompleted(Bundle icicle);
	}
	
	static UserDataValidationDialogFragment newInstance() {
		UserDataValidationDialogFragment fragment = new UserDataValidationDialogFragment();
		return fragment;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.fragment_user_data, null);
		
		mFirstName = (EditText) view.findViewById(R.id.first_name);
		mLastName = (EditText) view.findViewById(R.id.last_name);
		mEmail = (EditText) view.findViewById(R.id.email_address);
		
		return new AlertDialog.Builder(getActivity())
				.setCancelable(false)
				.setView(view)
				.setIcon(R.drawable.ic_action_info)
				.setTitle(R.string.welcome)
				
				.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {	
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dataValidation();
					}
				}).create();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		showKeyboard();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		hideKeyboard();
	}
	private void dataValidation() {
		mFirstName.setError(null);
		mLastName.setError(null);
		mEmail.setError(null);
		
		String firstName = mFirstName.getText().toString();
		String lastName = mLastName.getText().toString();
		String email = mEmail.getText().toString();
		
		boolean cancel = false;
		View focusView = null;
		
		// Checking for valid first name
		if (TextUtils.isEmpty(firstName)) {
			mFirstName.setError(getString(R.string.error_field_required));
			focusView = mFirstName;
			cancel = true;
		}
		
		// Checking for valid last name
		if  (TextUtils.isEmpty(lastName)) {
			mLastName.setError(getString(R.string.error_field_required));
			focusView = mLastName;
			cancel = true;
		}
		
		// Check for valid email address.
		if (TextUtils.isEmpty(email)) {
			mEmail.setError(getString(R.string.error_field_required));
			focusView = mEmail;
			cancel = true;
		} else if (!email.contains("@")) {
			mEmail.setError(getString(R.string.error_invalid_email));
			focusView = mEmail;
			cancel = true;
		}
		
		if (cancel) {
			focusView.requestFocus();
		} else {
			editor.putBoolean(PREF_DATA_ENTERED, true).commit();
			
			/** TODO: WARNING UNSTABLE
			//JSONObject object = new JSONObject();
			object.put("first_name", firstName);
			object.put("last_name", lastName);
			object.put("email", email); **/
		}
	}
	
	private void hideKeyboard() {
		getDialog().getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_HIDDEN);
	}
	
	private void showKeyboard() {
		getDialog().getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_VISIBLE);
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("first_name", mFirstName.getText().toString());
		outState.putString("last_name", mLastName.getText().toString());
		outState.putString("email_address", mEmail.getText().toString());
	}
}
