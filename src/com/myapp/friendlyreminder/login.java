package com.myapp.friendlyreminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends Activity {

		EditText	get_email_address, get_password, get_confirm_password;
		Button 		save;
		
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		get_email_address = (EditText) findViewById(R.id.login_edit_email_address);
		get_password = (EditText) findViewById(R.id.login_edit_password);
		save = (Button) findViewById(R.id.login_save_bt);
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			// textOut.setText(get_email_address.getText());
				startActivity(new Intent("com.myapp.friendlyreminder.HOMEPAGE"));
			}
		});
		
	}
}
