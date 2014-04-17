package com.intravita.android.tsr.receiver;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

public class BluetoothReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle extras = intent.getExtras();
		int state = extras.getInt(BluetoothAdapter.EXTRA_STATE);
		
		if (state == BluetoothAdapter.STATE_OFF) {
			Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			enableBtIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(enableBtIntent);
		}
		
		LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
	}
}
