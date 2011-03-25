package com.myapp.friendlyreminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class create_acc extends Activity {

	EditText	get_email_address, get_password, get_confirm_password;
	Button 		save;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_account);
		
		get_email_address = (EditText) findViewById(R.id.email_address);
		get_password = (EditText) findViewById(R.id.password);
		get_confirm_password = (EditText) findViewById(R.id.confirm_password);
		Button save = (Button) findViewById(R.id.save_acc_info);
		save.setOnClickListener(new View.OnClickListener(
				) {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			// textOut.setText(get_email_address.getText());
				/* Not doing anything here now
				 * but we will store this in 
				 * database on online server after doing the following check.
				 * 1) Email verification for invalid characters
				 * 2) Password matches with confirm password.
				 * 3) Password is at-least 4 char longs.
				 * */
				startActivity(new Intent("com.myapp.friendlyreminder.HOMEPAGE"));
			}
		});
	}
	
}
