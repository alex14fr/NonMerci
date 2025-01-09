package io.github.alex14fr.NonMerci;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.telecom.TelecomManager;
import android.util.Log;

public class Receiver extends BroadcastReceiver {
	private static final String[] blockedPrefixes = { 
		"0162", "0163", "0270", "0271", "0377", "0378", "0424", "0425", "0568", "0569", "0948", "0949", "09475", "09476", "09477", "09478", "09479",
		"+33162", "+33163", "+33270", "+33271", "+33377", "+33378", "+33424", "+33425", "+33568", "+33569", "+33948", "+33949", "+339475", "+339476", "+339477", "+339478", "+339479",
		};
	private static boolean AlreadyOnCall = false;
	public void onReceive(Context context, Intent intent) {
		Log.i("NonMerci", "onReceive() "+intent.getAction());
		if (TelephonyManager.ACTION_PHONE_STATE_CHANGED.equals(intent.getAction())) {
			String extraState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
			Log.i("NonMerci", "extraState="+extraState);
			if (extraState.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
				AlreadyOnCall = true;
			} else if (extraState.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
				AlreadyOnCall = false;
			} else if (extraState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
				String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
				Log.i("NonMerci", "incomingNumber = "+incomingNumber);
					if (AlreadyOnCall || (incomingNumber == null))
						return;
				for(int i=0; i<blockedPrefixes.length; i++) {
					if(incomingNumber.startsWith(blockedPrefixes[i])) {
						Log.i("NonMerci", "BLOCK");
						TelecomManager tm=(TelecomManager)context.getSystemService(Context.TELECOM_SERVICE);
						tm.endCall();
						return;
					}
				}
				Log.i("NonMerci", "PASS");
			}
		}
	}
}

