package io.github.alex14fr.NonMerci;
import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;

public class MActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		String[] perm = { "android.permission.ANSWER_PHONE_CALLS", "android.permission.CALL_PHONE", "android.permission.MODIFY_PHONE_STATE", "android.permission.READ_CALL_LOG", "android.permission.READ_PHONE_STATE", "android.permission.READ_PRIVILEGIED_PHONE_STATE" };
		super.onCreate(savedInstanceState);
		requestPermissions(perm,1);
		TextView tv=new TextView(this);
		tv.setText("Blocking is on. Uninstall this application to disable it. \n");
		setContentView(tv);
	}
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) { }
}

