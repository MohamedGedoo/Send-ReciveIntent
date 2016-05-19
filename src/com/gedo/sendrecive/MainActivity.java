package com.gedo.sendrecive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText employeeSalary, employeeName;
	TextView netSalary;

	public void calculate(View view) {

		String name, salary;

		name = employeeName.getText().toString();
		salary = employeeSalary.getText().toString();

		Intent send = new Intent(MainActivity.this, Reciever.class);
		send.putExtra("name", name);
		send.putExtra("salary", salary);
		startActivity(send);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		employeeName = (EditText) findViewById(R.id.etName);
		employeeSalary = (EditText) findViewById(R.id.etSalary);
		netSalary = (TextView) findViewById(R.id.tvNet);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
