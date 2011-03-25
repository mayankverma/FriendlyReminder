package com.myapp.friendlyreminder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FriendReminder extends Activity {
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        Button create_acc_button = (Button) findViewById(R.id.create_account_bt);
        create_acc_button.setOnClickListener(new View.OnClickListener() {
	       	@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.myapp.friendlyreminder.CREATEACCOUNT"));
	       	}
      	});
        
        Button log_in_button = (Button) findViewById(R.id.log_in_bt);
        log_in_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.myapp.friendlyreminder.LOGIN"));
			}
		});

    }
    
}