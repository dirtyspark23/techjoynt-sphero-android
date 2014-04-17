package com.intravita.android.tsr.fragment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.intravita.android.tsr.R;
import com.intravita.android.tsr.activity.RemoteControl;

public class BluetoothTurnedOffDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		builder.setTitle(R.string.bluetooth_required);
		builder.setIcon(R.drawable.ic_action_bluetooth);
		builder.setMessage(R.string.bluetooth_required_message);
		builder.setCancelable(false);
		
		builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//RemoteControl parentActivity = (RemoteControl) getActivity();
				
				dialog.dismiss();
				//parentActivity.startBluetooth();
			}
		});
		
		return builder.create();
	}
}
