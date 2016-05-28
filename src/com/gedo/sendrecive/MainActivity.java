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

		//Get data from InputText
		name = employeeName.getText().toString();
		salary = employeeSalary.getText().toString();

		// Create Intent to call the Receiver Activity and send Data with it
	
		Intent send = new Intent(MainActivity.this, Reciever.class);
		send.putExtra("name", name);
		send.putExtra("salary", salary);
		//Start the Activity and wait for result
		startActivityForResult(send, 0);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		employeeName = (EditText) findViewById(R.id.etName);
		employeeSalary = (EditText) findViewById(R.id.etSalary);
		netSalary = (TextView) findViewById(R.id.tvNet);

	}

	
	// processing on the data that returned from the Reciever Activity
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 0 && resultCode == RESULT_OK) {

			int valueOfSalary = data.getExtras().getInt("valueOfSalary");
			netSalary.setText(String.valueOf(valueOfSalary));
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
