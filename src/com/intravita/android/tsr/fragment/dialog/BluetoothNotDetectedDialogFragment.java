package com.intravita.android.tsr.fragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.intravita.android.tsr.R;

public class BluetoothNotDetectedDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		builder.setTitle(R.string.no_bluetooth);
		builder.setIcon(R.drawable.ic_action_bluetooth);
		builder.setMessage(R.string.no_bluetooth_message);
		
		builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				getActivity().finish();
			}
		});
		
		return builder.create();
	}
}
