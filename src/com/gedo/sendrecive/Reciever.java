package com.gedo.sendrecive;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Reciever extends Activity {
	TextView na, sa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reciever);
		na = (TextView) findViewById(R.id.nameEmp);
		sa = (TextView) findViewById(R.id.salemp);

		Intent reciev = this.getIntent();
		na.setText(reciev.getStringExtra("name"));
		sa.setText(reciev.getStringExtra("salary"));
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reciever, menu);
		return true;
	}

}
